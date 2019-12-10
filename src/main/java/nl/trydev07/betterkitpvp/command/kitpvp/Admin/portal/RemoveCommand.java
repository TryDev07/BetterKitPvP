package nl.trydev07.betterkitpvp.command.kitpvp.Admin.portal;

import nl.trydev07.betterkitpvp.handlers.PortalHandler;

/* TryDev07 created on 12/10/2019
 * Project:  BetterKitPvP 
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class RemoveCommand {

    public RemoveCommand(String name){
        PortalHandler.getPortalHandler(name).Remove();
    }
}
