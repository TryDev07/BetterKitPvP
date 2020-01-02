package nl.trydev07.betterkitpvp.handlers.oop;

import org.bukkit.entity.EntityType;

/* TryDev07 created on 12/13/2019
 * Project:  BetterKitPvP 
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class OOPNpc {

    private String name;
    private EntityType entity;
    private String location;
    private String colorName;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EntityType getEntity() {
        return entity;
    }

    public void setEntity(EntityType entity) {
        this.entity = entity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }
}
