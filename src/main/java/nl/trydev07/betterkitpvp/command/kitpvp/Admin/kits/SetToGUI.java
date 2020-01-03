package nl.trydev07.betterkitpvp.command.kitpvp.Admin.kits;

import nl.trydev07.betterkitpvp.handlers.KitHandler;
import org.bukkit.entity.Player;

/* TryDev07 created on 03/01/2020
 * Project:  BetterKitPvP
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class SetToGUI {

    String type;

    public SetToGUI(String kitName){
        this.type = kitName;
    }

    public void initialize(String GUIName, Integer slot){
        if(type != null || GUIName != null || slot != null) {
            KitHandler.getKit(type).setKitToGUI(GUIName, slot);
        }
    }
}
