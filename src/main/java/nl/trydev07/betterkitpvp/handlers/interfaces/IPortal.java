package nl.trydev07.betterkitpvp.handlers.interfaces;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

/* TryDev07 created on 12/9/2019
 * Project:  BetterKitPvP
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public interface IPortal {

    /**
     * Create a custom portal to random teleport you to the KitPVP map
     *
     * @param name give the portal you want to create a name.,
     */
    void Create(String name);

    /**
     * Remove the custom portal.
     */
    void Remove();

    /**
     * Set the material of all air blocks in the portal.
     *
     * @param portalName Contains the name of the portal.
     * @param material   Contains the material you want to change your portal into.
     */
    void setMaterial(String portalName, Material material);

    /**
     * Save the PortalHandler class to our data folder as a JSON File.
     */
    void save();

    /**
     * Loading all the data from the JSON file that was made when closing the plugin.
     */
    void loadPortals();


}
