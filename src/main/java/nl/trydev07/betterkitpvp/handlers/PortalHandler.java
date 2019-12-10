package nl.trydev07.betterkitpvp.handlers;

import nl.trydev07.betterkitpvp.Core;
import nl.trydev07.betterkitpvp.handlers.interfaces.InterfacePortal;
import nl.trydev07.betterkitpvp.handlers.oob.OOBPortal;
import nl.trydev07.betterkitpvp.utilitys.LocationDeserializer;
import nl.trydev07.betterkitpvp.utilitys.utils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.logging.Level;

/* TryDev07 created on 12/9/2019
 * Project:  BetterKitPvP
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class PortalHandler implements InterfacePortal {

    private static PortalHandler portalHandler;

    public static PortalHandler getPortalHandler() {
        return portalHandler;
    }

    private HashMap<String, OOBPortal> portals = new HashMap<String, OOBPortal>();

    public PortalHandler() {
        portalHandler = this;
    }

    @Override
    public void Create(String name) {
        if(name != null){
            OOBPortal oobPortal = new OOBPortal();
            portals.put(name, oobPortal);
        }
    }

    @Override
    public void setMaterial(String portalName, Material material) {
        if (material != null) {
            if(portalName != null) {
                OOBPortal oobPortal = portals.get(portalName);
                Location point1 = LocationDeserializer.getLocationFromString(oobPortal.getLoc1());
                Location point2 = LocationDeserializer.getLocationFromString(oobPortal.getLoc2());
                Vector max = Vector.getMaximum(point1.toVector(), point2.toVector());
                Vector min = Vector.getMinimum(point1.toVector(), point2.toVector());
                for (int i = min.getBlockX(); i <= max.getBlockX(); i++) {
                    for (int j = min.getBlockY(); j <= max.getBlockY(); j++) {
                        for (int k = min.getBlockZ(); k <= max.getBlockZ(); k++) {
                            Block block = Core.getInstance().getServer().getWorld(point1.getWorld().toString()).getBlockAt(i, j, k);
                            if (block.getType() == Material.AIR) {
                                block.setType(material);
                            }
                        }
                    }
                }
                oobPortal.setMaterial(material);
            }else{
                utils.Logger(Level.WARNING, "PortalName of the setMaterial == null. Please inform a developer of the plugin!");
            }
        } else {
            utils.Logger(Level.WARNING, "material of the setMaterial == null. Please inform a developer of the plugin!");
        }
    }

    @Override
    public void setLocations(String portalName, Location location1, Location location2) {
        if(portalName != null) {
            OOBPortal oobPortal = portals.get(portalName);
            if (location1 != null || location2 != null) {
                oobPortal.setLoc1(LocationDeserializer.getStringFromLocation(location1));
                oobPortal.setLoc2(LocationDeserializer.getStringFromLocation(location2));
            } else {
                utils.Logger(Level.WARNING, "Location1 or Location2 of the setLocations == null. Please inform a developer of the plugin!");
            }
        }else{
            utils.Logger(Level.WARNING, "PortalName of the setLocations == null. Please inform a developer of the plugin!");

        }
    }


    @Override
    public void loadPortals() {

    }

    @Override
    public void save() {

    }


}
