package nl.trydev07.betterkitpvp.handlers;

import com.google.gson.Gson;
import nl.trydev07.betterkitpvp.Core;
import nl.trydev07.betterkitpvp.handlers.interfaces.IKit;
import nl.trydev07.betterkitpvp.handlers.oop.OOPKit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* TryDev07 created on 02/01/2020
 * Project:  BetterKitPvP
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class KitHandler implements IKit {


    private static Map<String, KitHandler> kitHandlerMap = new HashMap<String, KitHandler>();

    public static KitHandler getKit(String name) {
        if (!(kitHandlerMap.isEmpty())) {
            for (String s : kitHandlerMap.keySet()) {
                if (name.equals(s)) {
                    return kitHandlerMap.get(name);
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    OOPKit<String> oopKit = new OOPKit<String>();
    Gson gson = new Gson();

    public KitHandler(String kitName) {
        create(kitName);
    }

    @Override
    public void create(String kitName) {
        if (!(kitName.isEmpty())) {
            if (oopKit == null)
                new OOPKit<String>();
            oopKit.setName(kitName.toLowerCase());
            kitHandlerMap.put(kitName, this);
        }
    }

    @Override
    public void remove(String kitName) {
        if (!kitHandlerMap.isEmpty()) {
            for (String kitMap : kitHandlerMap.keySet()) {
                if (kitMap.equalsIgnoreCase(kitName))
                    kitHandlerMap.remove(kitName);
            }
        }
    }

    @Override
    public void addItemToKit(ItemStack item) {
        if (item == null) return;
        oopKit.getItemStack().add(toBase64(item));
    }

    @Override
    public void setKitToGUI(String GuiName, Integer slot) {
        if(GUIHandler.getGUI(GuiName) == null) return;
        GUIHandler guiHandler = GUIHandler.getGUI(GuiName);

        ItemStack stack = guiHandler.getItemFromSlot("test", slot);

        if(stack == null) return;
        oopKit.setKitBind(toBase64(stack));
    }

    @Override
    public void save() {

        File file = new File(Core.getInstance().getDataFolder() + "\\Data\\Kits\\", oopKit.getName() + ".json");
        if (!file.exists()) {
            file.getParentFile().mkdirs();

            try {

                file.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        String json = gson.toJson(oopKit);
        try {
            FileWriter writer = new FileWriter(Core.getInstance().getDataFolder() + "\\Data\\Kits\\" + oopKit.getName() + ".json");
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void load() {
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader(Core.getInstance().getDataFolder() + "\\Data\\Kits\\" + oopKit.getName() + ".json"));
            oopKit = gson.fromJson(br, OOPKit.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setPrice(Integer price) {
        oopKit.setPrice(price);
    }

    @Override
    public Integer getPrice() {
        return oopKit.getPrice();
    }

    public OOPKit<String> getOopKit() {
        return oopKit;
    }


    public String toBase64(ItemStack itemStack) throws IllegalStateException {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            BukkitObjectOutputStream dataOutput = new BukkitObjectOutputStream(outputStream);


            dataOutput.writeObject(itemStack);

            dataOutput.close();
            return Base64Coder.encodeLines(outputStream.toByteArray());
        } catch (Exception e) {
            throw new IllegalStateException("Unable to save item stacks.", e);
        }
    }


    public ItemStack fromBase64(String data) throws IOException {
        try {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(Base64Coder.decodeLines(data));
            BukkitObjectInputStream dataInput = new BukkitObjectInputStream(inputStream);
            ItemStack itemStack = (ItemStack) dataInput.readObject();

            dataInput.close();
            return itemStack;
        } catch (ClassNotFoundException e) {
            throw new IOException("Unable to decode class type.", e);
        }
    }

}
