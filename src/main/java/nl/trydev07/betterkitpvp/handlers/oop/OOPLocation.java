package nl.trydev07.betterkitpvp.handlers.oop;

import java.util.HashMap;

/* TryDev07 created on 12/8/2019
 * Project:  BetterKitPvP
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class OOPLocation {

    String spawnLocation;
    HashMap<String, String> randomSpawnLocations = new HashMap<String, String>();

    public String getSpawnLocation() {
        return spawnLocation;
    }

    public void setSpawnLocation(String spawnLocation) {
        this.spawnLocation = spawnLocation;
    }

    public HashMap<String, String> getRandomSpawnLocations() {
        return randomSpawnLocations;
    }


    public void setRandomSpawnLocations(String name, String location) {
        randomSpawnLocations.put(name, location);
    }
}
