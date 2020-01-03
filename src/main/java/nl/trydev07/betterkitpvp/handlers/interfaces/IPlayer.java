package nl.trydev07.betterkitpvp.handlers.interfaces;

import nl.trydev07.betterkitpvp.handlers.KitHandler;
import org.bukkit.entity.Player;

import java.util.UUID;

/* TryDev07 created on 02/01/2020
 * Project:  BetterKitPvP
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public interface IPlayer {


    String getName();

    UUID getUUID();

    void loadPlayer(UUID uuid);

    void savePlayer(UUID uuid);

    Integer getBalance();

    void addBalance(Integer balance);

    void setBalance(Integer balance);
    void removeBalance(Integer balance);

    Integer getKills();

    void addKill();

    void setKills(Integer kills);

    void removeKills(Integer kills);

    Integer getDeaths();

    void addDeath();

    void setDeath(Integer death);

    void removeDeaths(Integer death);

    void getKits();

    void addKit(KitHandler kit);

    void removeKit(KitHandler kit);

    Player getPlayer();


}
