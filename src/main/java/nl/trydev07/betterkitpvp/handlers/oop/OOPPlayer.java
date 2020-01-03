package nl.trydev07.betterkitpvp.handlers.oop;

import nl.trydev07.betterkitpvp.handlers.KitHandler;

import java.util.List;
import java.util.Set;
import java.util.UUID;

/* TryDev07 created on 03/01/2020
 * Project:  BetterKitPvP
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class OOPPlayer {

    UUID uuid;
    Integer Balance;
    Integer kills;
    Integer deaths;
    List<KitHandler> kits;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Integer getBalance() {
        return Balance;
    }

    public void setBalance(Integer balance) {
        Balance = balance;
    }

    public Integer getKills() {
        return kills;
    }

    public void setKills(Integer kills) {
        this.kills = kills;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public List<KitHandler> getKits() {
        return kits;
    }

    public void setKits(List<KitHandler> kits) {
        this.kits = kits;
    }
}
