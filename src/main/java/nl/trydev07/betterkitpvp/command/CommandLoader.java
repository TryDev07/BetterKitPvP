package nl.trydev07.betterkitpvp.command;

import nl.trydev07.betterkitpvp.command.kitpvp.Admin.PortalCommand;
import nl.trydev07.betterkitpvp.command.kitpvp.Admin.ShopCommand;
import nl.trydev07.betterkitpvp.command.kitpvp.Admin.addRandomSpawnCommand;
import nl.trydev07.betterkitpvp.command.kitpvp.Admin.setSpawnCommand;
import nl.trydev07.betterkitpvp.command.kitpvp.helpCommand;

/* TryDev07 created on 12/10/2019
 * Project:  BetterKitPvP 
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class CommandLoader {

    public CommandLoader(){
        new setSpawnCommand();
        new addRandomSpawnCommand();
        new helpCommand();
        new PortalCommand();
        new ShopCommand();
    }
}
