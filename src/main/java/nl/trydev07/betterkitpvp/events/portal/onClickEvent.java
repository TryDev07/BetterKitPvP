package nl.trydev07.betterkitpvp.events.portal;

import nl.trydev07.betterkitpvp.handlers.PortalHandler;
import nl.trydev07.betterkitpvp.utilitys.utils;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/* TryDev07 created on 12/10/2019
 * Project:  BetterKitPvP 
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class onClickEvent implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent event){
        ItemStack stack = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta stackMeta = stack.getItemMeta();
        stackMeta.setDisplayName(utils.format("&8[&eBetterKitPvP&8]&7"));
        stackMeta.addEnchant(Enchantment.DURABILITY,1,false);
        stack.setItemMeta(stackMeta);

        if(event.getPlayer().getItemInHand().getType().equals(Material.DIAMOND_AXE)){
            if(event.getPlayer().getItemInHand().getItemMeta().equals(stack.getItemMeta())) {
                Action a = event.getAction();
                if (a == Action.LEFT_CLICK_BLOCK) {
                    PortalHandler.setLocation1(event.getClickedBlock().getLocation());
                    event.getPlayer().sendMessage(utils.format("&8[&eBetterKitPvP&8] &7- &fPosition 1 has been set"));
                }
                if (a == Action.RIGHT_CLICK_BLOCK) {
                    PortalHandler.setLocation2(event.getClickedBlock().getLocation());
                    event.getPlayer().sendMessage(utils.format("&8[&eBetterKitPvP&8] &7- &fPosition 2 has been set"));
                }
            }
        }
    }
}
