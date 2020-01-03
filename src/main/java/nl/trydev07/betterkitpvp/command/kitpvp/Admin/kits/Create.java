package nl.trydev07.betterkitpvp.command.kitpvp.Admin.kits;

import nl.trydev07.betterkitpvp.handlers.KitHandler;
import org.bukkit.inventory.ItemStack;

/* TryDev07 created on 03/01/2020
 * Project:  BetterKitPvP
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class Create {

    String type;

    public Create(String kitName){
        this.type = kitName;
    }

    public void initialize(){
        new KitHandler(type);
    }
}
