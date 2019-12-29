package nl.trydev07.betterkitpvp.handlers.interfaces;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

/* TryDev07 created on 12/13/2019
 * Project:  BetterKitPvP
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public interface InterfaceNpc {

    void addNpc(Location location, EntityType type, String name, String ColorName);

    void removeNpc();

    void save();

    void load();
}
