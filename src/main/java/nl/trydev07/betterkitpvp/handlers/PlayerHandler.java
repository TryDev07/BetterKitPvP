package nl.trydev07.betterkitpvp.handlers;

import nl.trydev07.betterkitpvp.handlers.interfaces.IPlayer;
import nl.trydev07.betterkitpvp.handlers.oop.OOPPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* TryDev07 created on 03/01/2020
 * Project:  BetterKitPvP
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class PlayerHandler implements IPlayer {

    private static Map<UUID, PlayerHandler> playerHandlerMap = new HashMap<UUID, PlayerHandler>();

    public static PlayerHandler getPlayer(UUID uuid) {
        if (!(playerHandlerMap.isEmpty())) {
            for (UUID s : playerHandlerMap.keySet()) {
                if (uuid.equals(s)) {
                    return playerHandlerMap.get(uuid);
                }
            }
        }
        return null;
    }

    public static Map<UUID, PlayerHandler> getPlayerHandlerMap() {
        return playerHandlerMap;
    }

    private OOPPlayer oopPlayer = new OOPPlayer();

    public PlayerHandler(UUID uuid) {
        oopPlayer.setUuid(uuid);
        playerHandlerMap.put(uuid, this);
    }

    @Override
    public String getName() {
        if (oopPlayer.getUuid() == null) throw new NullPointerException("Uuid is empty.");
        return Bukkit.getPlayer(oopPlayer.getUuid()).getName();
    }

    @Override
    public UUID getUUID() {
        return oopPlayer.getUuid();
    }

    @Override
    public void loadPlayer(UUID uuid) {

    }

    @Override
    public void savePlayer(UUID uuid) {

    }

    @Override
    public Integer getBalance() {
        return oopPlayer.getBalance();
    }

    @Override
    public void addBalance(Integer balance) {
        int i = oopPlayer.getBalance() + balance;
        oopPlayer.setBalance(i);
    }

    @Override
    public void setBalance(Integer balance) {
        oopPlayer.setBalance(balance);
    }

    @Override
    public void removeBalance(Integer balance){
        if(balance >= 0) {
            int i = oopPlayer.getBalance() - balance;
        }
    }


    @Override
    public Integer getKills() {
        return oopPlayer.getKills();
    }

    @Override
    public void addKill() {
        oopPlayer.setKills(oopPlayer.getKills() + 1);
    }

    @Override
    public void setKills(Integer kills) {
        oopPlayer.setKills(kills);

    }

    @Override
    public void removeKills(Integer kills) {
        oopPlayer.setKills(oopPlayer.getKills() - kills);

    }

    @Override
    public Integer getDeaths() {
        return oopPlayer.getDeaths();
    }

    @Override
    public void addDeath() {
        oopPlayer.setDeaths(oopPlayer.getDeaths() + 1);
    }

    @Override
    public void setDeath(Integer death) {
        oopPlayer.setKills(death);
    }

    @Override
    public void removeDeaths(Integer death) {
        oopPlayer.setDeaths(oopPlayer.getDeaths() - death);

    }

    @Override
    public void getKits() {
        oopPlayer.getKits();
    }

    @Override
    public void addKit(KitHandler kit) {
        oopPlayer.getKits().add(kit);
    }

    @Override
    public void removeKit(KitHandler kit) {
        oopPlayer.getKits().remove(kit);
    }

    @Override
    public Player getPlayer() {
        return Bukkit.getPlayer(oopPlayer.getUuid());
    }
}
