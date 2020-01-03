package nl.trydev07.betterkitpvp.handlers;

import com.google.gson.Gson;
import nl.trydev07.betterkitpvp.Core;
import nl.trydev07.betterkitpvp.handlers.interfaces.IPortal;
import nl.trydev07.betterkitpvp.handlers.oop.OOPPortal;
import nl.trydev07.betterkitpvp.utilitys.LocationDeserializer;
import nl.trydev07.betterkitpvp.utilitys.utils;
import nl.trydev07.betterkitpvp.events.portal.onWaterFlowEvent;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.util.Vector;

import java.io.*;
import java.util.*;
import java.util.logging.Level;

/* TryDev07 created on 12/9/2019
 * Project:  BetterKitPvP
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class PortalHandler implements IPortal {

    private static Map<String, PortalHandler> portalHandlerMap = new HashMap<String, PortalHandler>();

    public static Location location1;
    public static Location location2;

    public static Map<String, PortalHandler> getPortalHandlerMap() {
        return portalHandlerMap;
    }

    public static PortalHandler getPortalHandler(String name) {
        for (String string : portalHandlerMap.keySet()) {
            if (string.equals(name)) {
                return portalHandlerMap.get(name);
            } else {

            }
        }
        return null;
    }

    private OOPPortal portal = new OOPPortal();
    private Gson gson = new Gson();
    private String name;

    public Set<Location> locationList = new HashSet<Location>();

    public Set<Location> getLocationList() {
        return locationList;
    }

    public PortalHandler() {
    }

    public OOPPortal getOOBPortal() {
        return portal;
    }

    @Override
    public void Create(String name) {
        if (name != null) {
            this.name = name;
            portalHandlerMap.put(name, this);
        }

    }

    @Override
    public void Remove() {
        onWaterFlowEvent.FLOW = false;
        for(String s : portal.getLocationsOfWater()){
            Location loc = LocationDeserializer.getLocationFromString(s);

            Block block = loc.getWorld().getBlockAt(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
            block.setType(Material.AIR);
        }
        File file = new File(Core.getInstance().getDataFolder() + "\\Data\\Portals\\", name + ".json");
        if(file.exists() == true){
            file.delete();
        }
        portalHandlerMap.remove(name);
    }

    @Override
    public void setMaterial(String portalName, Material material) {
        if (material != null) {
            if (portalName != null) {
                Location point1 = location1;
                Location point2 = location2;
                onWaterFlowEvent.FLOW = false;

                Vector max = Vector.getMaximum(point1.toVector(), point2.toVector());
                Vector min = Vector.getMinimum(point1.toVector(), point2.toVector());
                for (int i = min.getBlockX(); i <= max.getBlockX(); i++) {
                    for (int j = min.getBlockY(); j <= max.getBlockY(); j++) {
                        for (int k = min.getBlockZ(); k <= max.getBlockZ(); k++) {
                            Block block = point1.getWorld().getBlockAt(i, j, k);
                            if (block.getType() == Material.AIR) {
                                block.setType(material);
                                portal.addLocationsOfWater(LocationDeserializer.getStringFromLocation(block.getLocation()));
                                locationList.add(block.getLocation());
                            }
                        }
                    }
                }
                portal.setMaterial(material);
                location1 = null;
                location2 = null;

            } else {
                utils.Logger(Level.WARNING, "PortalName of the setMaterial == null. Please inform a developer of the plugin!");
            }
        } else {
            utils.Logger(Level.WARNING, "material of the setMaterial == null. Please inform a developer of the plugin!");
        }
    }

    public static void setLocation1(Location loc1) {
        location1 = loc1;
    }

    public static void setLocation2(Location loc2) {
        location2 = loc2;
    }

    @Override
    public void loadPortals() {
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader(Core.getInstance().getDataFolder() + "\\Data\\Portals\\" + name + ".json"));
            utils.Logger(Level.WARNING, name);
            portal = gson.fromJson(br, OOPPortal.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String portalBlocks : PortalHandler.getPortalHandler(name).getOOBPortal().getLocationsOfWater()) {
            locationList.add(LocationDeserializer.getLocationFromString(portalBlocks));
        }
    }


    @Override
    public void save() {
        File file = new File(Core.getInstance().getDataFolder() + "\\Data\\Portals\\", name + ".json");
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        String json = gson.toJson(portal);
        try {
            FileWriter writer = new FileWriter(Core.getInstance().getDataFolder() + "\\Data\\Portals\\" + name + ".json");
            writer.write(json);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
