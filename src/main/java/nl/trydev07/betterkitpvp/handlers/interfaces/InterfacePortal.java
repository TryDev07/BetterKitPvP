package nl.trydev07.betterkitpvp.handlers.interfaces;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

/* TryDev07 created on 12/9/2019
 * Project:  BetterKitPvP 
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public interface InterfacePortal {

    void Create(String name);

    void setMaterial(String portalName, Material material);

    void setLocations(String portalName, Location location1, Location location2);

    void loadPortals();

    void save();

}
