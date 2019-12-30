package nl.trydev07.betterkitpvp.handlers.oob;

import org.bukkit.Location;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

/* TryDev07 created on 12/9/2019
 * Project:  BetterKitPvP
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class OOPPortal {

    String PortalName;
    Material material;
    List<String> locationsOfWater = new ArrayList<String>();

    public String getPortalName() {
        return PortalName;
    }

    public void setPortalName(String portalName) {
        PortalName = portalName;
    }

    public List<String> getLocationsOfWater() {
        return locationsOfWater;
    }

    public void addLocationsOfWater(String locations) {
        this.locationsOfWater.add(locations);
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

}
