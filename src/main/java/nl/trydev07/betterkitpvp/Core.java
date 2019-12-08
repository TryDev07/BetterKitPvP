package nl.trydev07.betterkitpvp;

import org.bukkit.plugin.java.JavaPlugin;

/* TryDev07 created on 12/8/2019
 * Project:  BetterKitPvP
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class Core extends JavaPlugin {

    private static Core instance;


    @Override
    public void onEnable() {
        instance = this;
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    public static Core getInstance() {
        return instance;
    }
}
