package nl.trydev07.betterkitpvp.handlers;

import com.google.gson.Gson;
import nl.trydev07.betterkitpvp.Core;
import nl.trydev07.betterkitpvp.handlers.interfaces.GUIInterface;
import nl.trydev07.betterkitpvp.handlers.oop.OOPGui;
import nl.trydev07.betterkitpvp.utilitys.InventoryDeserializer;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* TryDev07 created on 12/28/2019
 * Project:  BetterKitPvP
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */

public class GUIHandler implements GUIInterface {

    private static Map<String, GUIHandler> GUIhandlermap = new HashMap<String, GUIHandler>();

    public static GUIHandler getGUI(String name) {
        if (!(GUIhandlermap.isEmpty())) {
            for (String s : GUIhandlermap.keySet()) {
                System.out.println(s);
                if (name.equals(s)) {
                    return GUIhandlermap.get(name);
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    public static Map<String, GUIHandler> getGUIHandlerMap() {
        return GUIhandlermap;
    }

    private Map<String, Inventory> inventoryMap = new WeakHashMap<String, Inventory>();

    private Inventory inventory;
    private String guiName;
    private OOPGui OOPGui;
    private Gson gson = new Gson();

    public GUIHandler(String name) {
        if (!(GUIhandlermap.isEmpty())) {
            for (String s : GUIhandlermap.keySet()) {
                System.out.println(s);
                if (name.equals(s)) {
                    GUIhandlermap.get(name);
                } else {
                    guiName = name;
                    GUIhandlermap.put(name, this);
                }
            }
        } else {
            guiName = name;
            GUIhandlermap.put(name, this);
        }

    }


    @Override
    public void createInventory(InventoryHolder holder, String invName, Integer slots) {

        if (!isIntLegit(slots)) {
            slots = makeIntLegit(slots);
        }
        if (inventoryMap.get(invName) == null) {
            inventory = Bukkit.createInventory(holder, slots, invName);
            inventoryMap.put(invName, this.inventory);
            inventory = null;
        } else {
            //inv exists
        }
    }

    @Override
    public void removeInventory(String invName) {
        if (inventoryMap.get(invName) != null) {
            inventoryMap.remove(invName);
        } else {
            // doesn't exists
        }
    }

    @Override
    public void removeGUI(String guiName) {
        if (GUIhandlermap.get(guiName) != null) {
            GUIhandlermap.remove(guiName);
        } else {
            // doesn't exists
        }
    }

    @Override
    public void addItem(String invName, ItemStack item, Integer slot) {
        slot = slot - 1;
        if (IsSlotLegit(invName, slot)) {
            if (inventoryMap.get(invName) != null) {
                if (inventoryMap.get(invName).getItem(slot) == null) {
                    inventoryMap.get(invName).setItem(slot, item);
                } else {
                    //Their is already a item
                }
            } else {
                //inv dousn't exixts
            }
        } else {
            //Slot dousn't exixst
        }

    }


    @Override
    public void removeItem(String invName, Integer slot) {
        if (inventoryMap.get(invName) != null) {
            ItemStack stack = inventoryMap.get(invName).getItem(slot);
            inventoryMap.get(invName).remove(stack);
        } else {
            //inv dousn't exixts
        }
    }


    @Override
    public void saveGUI() {
        OOPGui = new OOPGui();

        if (!inventoryMap.isEmpty()) {
            for (Map.Entry<String, Inventory> inventoryEntry : inventoryMap.entrySet()) {
                OOPGui.getInventory().put(inventoryEntry.getKey(), InventoryDeserializer.toBase64(inventoryEntry.getValue()));
            }
        }
        File file = new File(Core.getInstance().getDataFolder() + "\\Data\\GUI\\", guiName + ".json");
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        String json = gson.toJson(OOPGui);
        try {
            FileWriter writer = new FileWriter(Core.getInstance().getDataFolder() + "\\Data\\GUI\\" + guiName + ".json");
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadGUI() {
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader(Core.getInstance().getDataFolder() + "\\Data\\GUI\\" + guiName + ".json"));

            OOPGui = gson.fromJson(br, OOPGui.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!OOPGui.getInventory().isEmpty()) {
            try {
                for (Map.Entry<String, String> s : OOPGui.getInventory().entrySet()) {
                    inventoryMap.put(s.getKey(), InventoryDeserializer.fromBase64(s.getValue()));

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Map<String, Inventory> getInventoryMap() {
        return inventoryMap;
    }

    public ItemStack[] getItems(String invName) {
        if (inventoryMap.get(invName) != null) {
            return inventoryMap.get(invName).getContents();
        }
        return null;
    }

    private boolean isIntLegit(int i) {
        int[] ints = {9, 18, 27, 36, 45, 54};

        for (Integer legit : ints) {
            if (i == legit) {
                System.out.println(true);

                return true;

            } else {
                System.out.println(false);

                return false;
            }
        }
        return false;
    }

    private Integer makeIntLegit(int i) {
        if (i < 9) {
            return 9;
        } else if (i > 9) {
            return 18;
        } else if (i > 18) {
            return 27;
        } else if (i > 27) {
            return 36;
        } else if (i > 36) {
            return 45;
        } else if (i > 45) {
            return 54;
        } else {
            throw new NullPointerException();
        }
    }


    private Boolean IsSlotLegit(String name, int i) {
        if (i < inventoryMap.get(name).getSize()) {
            return true;
        } else {
            return false;
        }
    }

    public ItemStack getItemFromSlot(String invName, int slot) {
        return inventoryMap.get(invName).getItem(slot);
    }
}
