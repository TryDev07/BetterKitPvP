package nl.trydev07.betterkitpvp.command.kitpvp;

import nl.trydev07.betterkitpvp.command.CommandHandler;
import org.bukkit.command.CommandSender;

/* TryDev07 created on 12/9/2019
 * Project:  BetterKitPvP 
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class helpCommand extends CommandHandler {

    public helpCommand(){
        super("help","BetterKitPvP.help",false);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

    }
}
