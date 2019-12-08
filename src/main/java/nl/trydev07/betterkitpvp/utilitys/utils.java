package nl.trydev07.betterkitpvp.utilitys;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.logging.Level;
import java.util.logging.Logger;

public class utils {

    public static String format(String msg){
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static void Logger(Level type, String msg){
        Logger log = Bukkit.getLogger();
        log.log(type, "[BetterKitPvP] - " +  msg);
    }
}
