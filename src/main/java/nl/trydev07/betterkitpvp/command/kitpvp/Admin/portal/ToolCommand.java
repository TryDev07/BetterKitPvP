package nl.trydev07.betterkitpvp.command.kitpvp.Admin.portal;

import nl.trydev07.betterkitpvp.utilitys.utils;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/* TryDev07 created on 12/10/2019
 * Project:  BetterKitPvP 
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class ToolCommand {


    public ToolCommand(Player player){
        ItemStack stack = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta stackMeta = stack.getItemMeta();
        stackMeta.setDisplayName(utils.format("&8[&eBetterKitPvP&8]&7"));
        stackMeta.addEnchant(Enchantment.DURABILITY,1,false);
        stack.setItemMeta(stackMeta);

        player.getInventory().addItem(stack);
    }
}
