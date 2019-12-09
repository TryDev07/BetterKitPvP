package nl.trydev07.betterkitpvp.handlers.interfaces;


import org.bukkit.Location;
import org.bukkit.entity.Player;

/* TryDev07 created on 12/8/2019
 * Project:  BetterKitPvP
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public interface InterfaceLocation {

    void setSpawnPoint(Player player);

    void addRandomSpawnPoint(String name, Player player);

    void loadLocations();

    void save();

}
