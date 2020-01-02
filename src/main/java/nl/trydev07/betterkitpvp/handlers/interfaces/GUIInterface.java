package nl.trydev07.betterkitpvp.handlers.interfaces;

import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public interface GUIInterface {


    /**
     * Creating a inventory into our GUIHandler.
     *
     * @param holder  Contains the inventory holder of our Inventory.
     * @param InvName Add a custom inventory name to our Inventory.
     * @param slots   Set the amount of slots for the inventory (9,18,27,36,45,54).
     */
    void createInventory(InventoryHolder holder, String InvName, Integer slots);

    /**
     * Removing a inventory out of our GUIHandler.
     *
     * @param InvName Contains the name of the inventory color#1 (Has to be a valid name)
     */
    void removeInventory(String InvName);

    /**
     * Remove a GUI out of the Map and Memory.
     *
     * @param InvName
     */
    void removeGUI(String InvName);

    /**
     * Add a item to a Inventory.
     *
     * @param invName Contains the name of the inventory you want to add the item to.
     * @param item    Contains a ItemStack (the item that you are adding).
     * @param slot    Contains the slot you want to put your item into.
     */
    void addItem(String invName, ItemStack item, Integer slot);

    /**
     * Remove a item from a certain slot in the Inventory.
     *
     * @param invName Contains the name of the inventory you want to remove the item from.
     * @param slot    Contains the slot you want to put remove your item from..
     */
    void removeItem(String invName, Integer slot);

    /**
     * Save the GUIHandler class to our data folder as a JSON File.
     */
    void saveGUI();

    /**
     * Loading all the data from the JSON file that was made when closing the plugin.
     */
    void loadGUI();

    /**
     * Method to check which item is on the selected slot.
     * @param slot Slot you want to take the item from.
     * @param invName Contains the name of the inventory.
     * @return ItemStack from the slot.
     */
    ItemStack getItemFromSlot(String invName, int slot);
}
