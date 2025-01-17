package nl.trydev07.betterkitpvp.handlers;

import com.google.gson.Gson;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import nl.trydev07.betterkitpvp.Core;
import nl.trydev07.betterkitpvp.handlers.interfaces.INpc;
import nl.trydev07.betterkitpvp.handlers.oop.OOPNpc;
import nl.trydev07.betterkitpvp.utilitys.LocationDeserializer;
import nl.trydev07.betterkitpvp.utilitys.utils;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.entity.*;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* TryDev07 created on 12/13/2019
 * Project:  BetterKitPvP
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class NPCHandler implements INpc {


    private static Map<String, NPCHandler> NPCHandler = new HashMap<String, NPCHandler>();

    public static NPCHandler getNpcHandler(String name, Player player) {
        if (!(name.isEmpty())) {
            for (String npc : NPCHandler.keySet()) {
                if (npc.equals(name)) {
                    return NPCHandler.get(name);
                }
            }
        }
        return null;
    }

    public static Map<String, NPCHandler> getNPCHandler() {
        return NPCHandler;
    }

    private Gson gson = new Gson();
    private OOPNpc oobNpc;

    private String name;
    private String colorName;
    private EntityType entityType;
    private Location location;
    private Entity entity;

    private ArmorStand as;


    public NPCHandler(String name) {
        oobNpc = new OOPNpc();

        NPCHandler.put(name, this);
        this.name = name;
    }

    @Override
    public void addNpc(Location location, EntityType type, String name, String colorName) {

        location.setPitch(0);
        this.name = name;
        this.location = location;
        this.colorName = colorName;
        this.entityType = type;


        LivingEntity villager = (LivingEntity) location.getWorld().spawnEntity(location, type);
        villager.setCustomName(colorName);
        villager.setNoDamageTicks(1000000000);
        setAI(villager);

        as = (ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        as.setCustomName(colorName);
        as.setCustomNameVisible(true);
        as.setGravity(false);
        as.setVisible(false);

        this.entity = villager;
    }


    @Override
    public void removeNpc() {
        entity.remove();
        as.remove();
        File file = new File(Core.getInstance().getDataFolder() + "\\Data\\NPC\\", name + ".json");

        file.delete();
        getNPCHandler().remove(name);
    }

    @Override
    public void save() {
        oobNpc.setName(this.name);
        oobNpc.setColorName(this.colorName);
        oobNpc.setEntity(this.entityType);
        oobNpc.setLocation(LocationDeserializer.getStringFromLocation(this.location));

        File file = new File(Core.getInstance().getDataFolder() + "\\Data\\NPC\\", name + ".json");
        if (!file.exists()) {
            file.getParentFile().mkdirs();

            try {

                file.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        String json = gson.toJson(oobNpc);
        try {
            FileWriter writer = new FileWriter(Core.getInstance().getDataFolder() + "\\Data\\NPC\\" + name + ".json");
            writer.write(json);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        entity.remove();
        as.remove();
    }

    @Override
    public void load() {
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader(Core.getInstance().getDataFolder() + "\\Data\\NPC\\" + name + ".json"));
            oobNpc = gson.fromJson(br, OOPNpc.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.name = getOobNpc().getName();
        this.colorName = getOobNpc().getColorName();
        this.entityType = getOobNpc().getEntity();
        this.location = LocationDeserializer.getLocationFromString(getOobNpc().getLocation());


        addNpc(this.location, this.entityType, this.name, this.colorName);
    }


    public OOPNpc getOobNpc() {
        return oobNpc;
    }


    public void setAI(Entity entity) {
        net.minecraft.server.v1_8_R3.Entity nmsVil = ((CraftEntity) entity).getHandle();
        NBTTagCompound comp = new NBTTagCompound();
        nmsVil.c(comp);
        comp.setByte("NoAI", (byte) 1);
        nmsVil.f(comp);
        nmsVil.b(true);
    }


}
