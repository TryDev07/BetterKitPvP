package nl.trydev07.betterkitpvp.handlers.interfaces;

import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public interface GUIInterface {


    void createInventory(InventoryHolder holder, String InvName, Integer slots);

    void removeInventory(String InvName);

    void removeGUI(String InvName);

    void addItem(String invName, ItemStack item, Integer slot);

    void removeItem(String invName, Integer slot);

    void saveGUI();

    void loadGUI();
}
