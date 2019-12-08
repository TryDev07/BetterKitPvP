package nl.trydev07.betterkitpvp.handlers.interfaces;


import org.bukkit.Location;

/* TryDev07 created on 12/8/2019
 * Project:  BetterKitPvP
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public interface InterfaceLocation {

    void setSpawnPoint(Location location);

    void addRandomSpawnPoint(String name, Location location);

    void loadLocations();

    void save();

}
