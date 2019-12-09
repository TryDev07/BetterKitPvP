package nl.trydev07.betterkitpvp.command.kitpvp.Admin;

import nl.trydev07.betterkitpvp.Core;
import nl.trydev07.betterkitpvp.command.CommandHandler;
import nl.trydev07.betterkitpvp.handlers.LocationHandler;
import nl.trydev07.betterkitpvp.utilitys.utils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/* TryDev07 created on 12/9/2019
 * Project:  BetterKitPvP
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class addRandomSpawnCommand extends CommandHandler {

    public addRandomSpawnCommand() {
        super("AddRandomSpawn", "BetterKitPvP.Admin", false);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        if(args[0] == null){
            sender.sendMessage(utils.format(Core.getFileManager().getConfig("Messages.yml").get("RandomSpawnPointName").toString()));
        }else {
            LocationHandler.getLocationHandler().addRandomSpawnPoint(args[0], p);
        }
    }
}
