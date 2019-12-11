package nl.trydev07.betterkitpvp.command.kitpvp.Admin.portal;

import nl.trydev07.betterkitpvp.events.portal.onWaterFlowEvent;
import nl.trydev07.betterkitpvp.handlers.PortalHandler;
import org.bukkit.Material;
import org.bukkit.entity.Player;

/* TryDev07 created on 12/10/2019
 * Project:  BetterKitPvP 
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class CreateCommand {


    public CreateCommand(Player player, String name, Material material){
        new PortalHandler().Create(name);
        PortalHandler.getPortalHandler(name).setMaterial(name, material, player);
    }
}
