package nl.trydev07.betterkitpvp;

import nl.trydev07.betterkitpvp.utilitys.FileManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

/* TryDev07 created on 12/8/2019
 * Project:  BetterKitPvP
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class Core extends JavaPlugin {

    private static Core instance;
    private static FileManager fileManager;


    private File f;
    private FileConfiguration fc;

    @Override
    public void onEnable() {
        instance = this;
        fileManager = new FileManager(instance);
        fileManager.getConfig("Messages.yml").copyDefaults(true).save();
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    public static FileManager getFileManager() {
        return fileManager;
    }

    public static Core getInstance() {
        return instance;
    }
}
