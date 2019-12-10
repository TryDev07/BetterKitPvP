package nl.trydev07.betterkitpvp.handlers.oob;

import org.bukkit.Location;
import org.bukkit.Material;

/* TryDev07 created on 12/9/2019
 * Project:  BetterKitPvP
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class OOBPortal {

    String PortalName;

    String loc1;
    String loc2;

    Material material;

    public String getPortalName() {
        return PortalName;
    }

    public void setPortalName(String portalName) {
        PortalName = portalName;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public String getLoc1() {
        return loc1;
    }

    public void setLoc1(String loc1) {
        this.loc1 = loc1;
    }

    public String getLoc2() {
        return loc2;
    }

    public void setLoc2(String loc2) {
        this.loc2 = loc2;
    }
}
