package nl.trydev07.betterkitpvp.command.kitpvp.Admin;

import nl.trydev07.betterkitpvp.command.CommandHandler;
import nl.trydev07.betterkitpvp.handlers.LocationHandler;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/* TryDev07 created on 12/9/2019
 * Project:  BetterKitPvP 
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class setSpawnCommand extends CommandHandler {

    public setSpawnCommand(){
        super("SetSpawn","BetterKitPvP.Admin",false);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        LocationHandler.getLocationHandler().setSpawnPoint(p);
    }
}
