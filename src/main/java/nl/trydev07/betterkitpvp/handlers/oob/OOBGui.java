package nl.trydev07.betterkitpvp.handlers.oob;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* TryDev07 created on 29/12/2019
 * Project:  BetterKitPvP
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class OOBGui {


    Map<String, String> inventory = new HashMap<String, String>();

    public Map<String, String> getLocations() {
        return inventory;
    }

    public void setLocations(Map<String, String> locations) {
        this.inventory = locations;
    }

}
