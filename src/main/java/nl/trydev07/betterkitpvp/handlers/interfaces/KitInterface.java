package nl.trydev07.betterkitpvp.handlers.interfaces;

import org.bukkit.inventory.ItemStack;

/* TryDev07 created on 02/01/2020
 * Project:  BetterKitPvP
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public interface KitInterface {


    void create(String kitName);

    void remove(String kitName);

    void addItemToKit(ItemStack Item);

    void setKitToGUI(String GuiName, Integer slot);

    void save();

    void load();


}
