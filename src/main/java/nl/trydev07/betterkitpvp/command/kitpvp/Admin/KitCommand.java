/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package nl.trydev07.betterkitpvp.command.kitpvp.Admin;

import nl.trydev07.betterkitpvp.Core;
import nl.trydev07.betterkitpvp.command.CommandHandler;
import nl.trydev07.betterkitpvp.command.kitpvp.Admin.kits.AddItem;
import nl.trydev07.betterkitpvp.command.kitpvp.Admin.kits.Create;
import nl.trydev07.betterkitpvp.command.kitpvp.Admin.kits.Delete;
import nl.trydev07.betterkitpvp.command.kitpvp.Admin.kits.SetToGUI;
import nl.trydev07.betterkitpvp.command.kitpvp.Admin.portal.CreateCommand;
import nl.trydev07.betterkitpvp.command.kitpvp.Admin.portal.RemoveCommand;
import nl.trydev07.betterkitpvp.command.kitpvp.Admin.portal.ToolCommand;
import nl.trydev07.betterkitpvp.events.portal.onWaterFlowEvent;
import nl.trydev07.betterkitpvp.handlers.KitHandler;
import nl.trydev07.betterkitpvp.handlers.PortalHandler;
import nl.trydev07.betterkitpvp.utilitys.utils;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/* TryDev07 created on 12/13/2019
 * Project:  BetterKitPvP
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */

public class KitCommand extends CommandHandler {

    public KitCommand() {
        super("Kits", "BetterKitPvP.Admin", false);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        if (args.length <= 0) {
            sender.sendMessage(utils.format("&7----------&8[&eBetterKitPvP&8]&7----------"));
            sender.sendMessage(utils.format(" &8•  &f/Kits Create [Name] &8- &7 Create a new kit."));
            sender.sendMessage(utils.format(" &8•  &f/Kits Remove [Name] &8- &7 Remove a existing kit."));
            sender.sendMessage(utils.format(" &8•  &f/kits AddItem &8- &7Hold the item you want to add in your hand"));
            sender.sendMessage(utils.format("&7----------&8[&eBetterKitPvP&8]&7----------"));
            return;
        } else if (args[0].toLowerCase().equalsIgnoreCase("create")) {
            if (args.length <= 1) {
                sender.sendMessage(utils.format("&7----------&8[&eBetterKitPvP&8]&7----------"));
                sender.sendMessage(utils.format(" &8•  &f/Kits Create [Name] &8- &7 Create a new kit."));
                sender.sendMessage(utils.format("&7----------&8[&eBetterKitPvP&8]&7----------"));
                return;
            }
            new Create(args[1]).initialize();
            return;
        } else if (args[0].toLowerCase().equalsIgnoreCase("remove")) {
            if (args.length <= 1) {
                sender.sendMessage(utils.format("&7----------&8[&eBetterKitPvP&8]&7----------"));
                sender.sendMessage(utils.format(" &8•  &f/Kits Remove [Name] &8- &7 Remove a existing kit."));
                sender.sendMessage(utils.format("&7----------&8[&eBetterKitPvP&8]&7----------"));
                return;
            }
            new Delete(args[1]).initialize();
            return;
        } else if (args[0].toLowerCase().equalsIgnoreCase("additem")) {
            if (p.getItemInHand().getType() == Material.AIR) {
                sender.sendMessage(utils.format("&7----------&8[&eBetterKitPvP&8]&7----------"));
                sender.sendMessage(utils.format(" &8•  &f/kits AddItem &8- &7Hold the item you want to add in your hand"));
                sender.sendMessage(utils.format("&7----------&8[&eBetterKitPvP&8]&7----------"));
                return;
            }
            new AddItem(args[1]).initialize(p.getItemInHand());
            return;
        } else {
            sender.sendMessage(utils.format("&7----------&8[&eBetterKitPvP&8]&7----------"));
            sender.sendMessage(utils.format("&7----------&8[&eBetterKitPvP&8]&7----------"));
        }
    }
}

