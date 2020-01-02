package nl.trydev07.betterkitpvp.handlers.interfaces;


import org.bukkit.Location;
import org.bukkit.entity.Player;

/* TryDev07 created on 12/8/2019
 * Project:  BetterKitPvP
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public interface InterfaceLocation {

    /**
     * Set the Default spawn point.
     *
     * @param player Getting the player to define his Location.
     */
    void setSpawnPoint(Player player);

    /**
     * Add a spawn point to our Set<Location></> to add a extra random location.
     *
     * @param name   name of the randomSpawnPoint
     * @param player Getting the player to define his Location.
     */
    void addRandomSpawnPoint(String name, Player player);

    /**
     * Save the LocationHandler class to our data folder as a JSON File.
     */
    void loadLocations();

    /**
     * Loading all the data from the JSON file that was made when closing the plugin.
     */
    void save();


}
