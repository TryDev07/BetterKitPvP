package nl.trydev07.betterkitpvp.handlers.oop;

import java.util.HashMap;
import java.util.Map;

/* TryDev07 created on 29/12/2019
 * Project:  BetterKitPvP
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class OOPGui {


    Map<String, String> inventory = new HashMap<String, String>();

    public Map<String, String> getInventory() {
        return inventory;
    }

    public void setInventory(Map<String, String> locations) {
        this.inventory = locations;
    }

}
