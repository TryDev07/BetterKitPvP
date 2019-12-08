package nl.trydev07.betterkitpvp.handlers.oob;

import org.bukkit.Location;

import java.util.HashMap;

/* TryDev07 created on 12/8/2019
 * Project:  BetterKitPvP
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class OOBLocation {

    Location spawnLocation;
    HashMap<String, Location> randomSpawnLocations = new HashMap<String, Location>();

    public Location getSpawnLocation() {
        return spawnLocation;
    }

    public void setSpawnLocation(Location spawnLocation) {
        this.spawnLocation = spawnLocation;
    }

    public HashMap<String, Location> getRandomSpawnLocations() {
        return randomSpawnLocations;
    }


    public void setRandomSpawnLocations(String name, Location location) {
        randomSpawnLocations.put(name, location);
    }
}
