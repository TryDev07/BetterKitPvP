package nl.trydev07.betterkitpvp.handlers;

import com.google.gson.Gson;
import nl.trydev07.betterkitpvp.Core;
import nl.trydev07.betterkitpvp.handlers.interfaces.InterfaceLocation;
import nl.trydev07.betterkitpvp.handlers.oob.OOBLocation;
import nl.trydev07.betterkitpvp.utilitys.LocationDeserializer;
import nl.trydev07.betterkitpvp.utilitys.utils;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.io.*;
import java.util.logging.Level;

/* TryDev07 created on 12/8/2019
 * Project:  BetterKitPvP
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class LocationHandler implements InterfaceLocation {

    private OOBLocation OOBLocation = new OOBLocation();
    private Gson gson = new Gson();
    private static LocationHandler locationHandler;

    public static LocationHandler getLocationHandler() {
        return locationHandler;
    }

    public LocationHandler() {
        locationHandler = this;
    }

    @Override
    public void setSpawnPoint(Player player) {
        if (player != null) {
            player.sendMessage(utils.format(Core.getFileManager().getConfig("Messages.yml").get("SpawnPoint").toString()));
            OOBLocation.setSpawnLocation(LocationDeserializer.getStringFromLocation(player.getLocation()));
        } else {
            utils.Logger(Level.WARNING, "Location of the setSpawnPoint == null. Please inform a developer of the plugin!");
        }
    }

    @Override
    public void addRandomSpawnPoint(String name, Player player) {
        if (player != null) {
            player.sendMessage(utils.format(Core.getFileManager().getConfig("Messages.yml").get("AddRandomSpawnPoint").toString().replaceAll("%NAME%", name)));
            OOBLocation.setRandomSpawnLocations(name, LocationDeserializer.getStringFromLocation(player.getLocation()));
        } else {
            utils.Logger(Level.WARNING, "Location of the AddRandomSpawnPoint == null. Please inform a developer of the plugin!");
        }
    }

    @Override
    public void loadLocations() {
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader(Core.getInstance().getDataFolder() + "\\Data\\Locations.json"));

            OOBLocation = gson.fromJson(br, OOBLocation.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save() {
        File file = new File(Core.getInstance().getDataFolder() + "\\Data\\", "Locations" + ".json");
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        String json = gson.toJson(OOBLocation);
        try {
            FileWriter writer = new FileWriter(Core.getInstance().getDataFolder() + "\\Data\\Locations.json");
            writer.write(json);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
