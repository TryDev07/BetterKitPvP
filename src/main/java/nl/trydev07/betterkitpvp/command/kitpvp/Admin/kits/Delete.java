package nl.trydev07.betterkitpvp.command.kitpvp.Admin.kits;

import nl.trydev07.betterkitpvp.handlers.KitHandler;

/* TryDev07 created on 03/01/2020
 * Project:  BetterKitPvP
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class Delete {
    String type;

    public Delete(String kitName){
        this.type = kitName;
    }

    public void initialize(){
        if(type != null) {
            KitHandler.getKit(type).remove(type);
        }
    }
}
