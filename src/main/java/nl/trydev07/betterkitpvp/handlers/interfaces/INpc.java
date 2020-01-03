package nl.trydev07.betterkitpvp.handlers.interfaces;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

/* TryDev07 created on 12/13/2019
 * Project:  BetterKitPvP
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public interface INpc {

    /**
     * Add a new NPC to the Client.
     *
     * @param location  Get the location of where you want to add the npc.
     * @param type      Select the Entity Type to determine which entity you want to spawn.
     * @param name      give the Entity a name.
     * @param ColorName add a custom name to our entity which is showed above his head.
     */
    void addNpc(Location location, EntityType type, String name, String ColorName);

    /**
     * Remove the npc that you made.
     */
    void removeNpc();

    /**
     * Save the NPCHandler class to our data folder as a JSON File.
     */
    void save();

    /**
     * Loading all the data from the JSON file that was made when closing the plugin.
     */
    void load();
}
