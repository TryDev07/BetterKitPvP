package nl.trydev07.betterkitpvp.command.kitpvp.Admin;

import nl.trydev07.betterkitpvp.command.CommandHandler;
import nl.trydev07.betterkitpvp.handlers.NPCHandler;
import nl.trydev07.betterkitpvp.utilitys.utils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

/* TryDev07 created on 14/12/2019
 * Project:  BetterKitPvP 
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class ShopCommand extends CommandHandler {

    public ShopCommand(){
        super("shop","BetterKitPvP.help",false);
    }


    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        new NPCHandler("test").addNpc(player.getLocation(), EntityType.VILLAGER,"test", utils.format("&eShop"));
    }
}
