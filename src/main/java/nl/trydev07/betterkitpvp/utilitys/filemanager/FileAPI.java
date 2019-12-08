package nl.trydev07.betterkitpvp.utilitys.filemanager;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

/* TryDev07 created on 12/7/2019
 * Project:  Defaults
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class FileAPI {
    private static UtilFile UF;

    public static UtilFile select(JavaPlugin plugin, File f, FileConfiguration fc) {
        UF = new UtilFile(plugin, f, fc);
        return UF;
    }
}
