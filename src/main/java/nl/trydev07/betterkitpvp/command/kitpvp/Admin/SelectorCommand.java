package nl.trydev07.betterkitpvp.command.kitpvp.Admin;


import nl.trydev07.betterkitpvp.Core;
import nl.trydev07.betterkitpvp.command.CommandHandler;
import nl.trydev07.betterkitpvp.handlers.GUIHandler;
import nl.trydev07.betterkitpvp.handlers.NPCHandler;
import nl.trydev07.betterkitpvp.utilitys.utils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

/* TryDev07 created on 14/12/2019
 * Project:  BetterKitPvP 
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class SelectorCommand extends CommandHandler {

    public SelectorCommand(){
        super("Selector","BetterKitPvP.help",false);
    }


    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        if (args.length <= 0) {
            sender.sendMessage(utils.format("&7----------&8[&eBetterKitPvP&8]&7----------"));
            sender.sendMessage(utils.format(" &8•  &f/Selector Create &8- &7 Create the Selector at your location."));
            sender.sendMessage(utils.format(" &8•  &f/Selector Remove &8- &7 Delete the existing Selector."));
            sender.sendMessage(utils.format("&7----------&8[&eBetterKitPvP&8]&7----------"));
            return;
        }
        if (args[0].toLowerCase().equalsIgnoreCase("create")) {
            new NPCHandler("Selector").addNpc(p.getLocation(), EntityType.VILLAGER,"Selector", utils.format("&eSelector"));
            sender.sendMessage(utils.format(Core.getFileManager().getConfig("Messages.yml").get("SelectorCreate").toString()));
            return;
        } else if (args[0].toLowerCase().equalsIgnoreCase("remove")) {
            NPCHandler.getNpcHandler("Selector", p).removeNpc();
            sender.sendMessage(utils.format(Core.getFileManager().getConfig("Messages.yml").get("SelectorRemove").toString()));
        } else if (args[0].toLowerCase().equalsIgnoreCase("addItem")) {
            new GUIHandler("Selector").createInventory(p, "test", 18);
            GUIHandler.getGUI("Selector").addItem("test", new ItemStack(Material.getMaterial(args[1].toUpperCase())), Integer.valueOf(args[2]));
            p.openInventory(GUIHandler.getGUI("Selector").getInventoryMap().get("test"));
        } else {
            sender.sendMessage(utils.format("&7----------&8[&eBetterKitPvP&8]&7----------"));
            sender.sendMessage(utils.format(" &8•  &f/Selector Create &8- &7 Create the Selector at your location."));
            sender.sendMessage(utils.format(" &8•  &f/Selector Remove &8- &7 Delete the existing Selector."));
            sender.sendMessage(utils.format("&7----------&8[&eBetterKitPvP&8]&7----------"));
        }
    }

}
