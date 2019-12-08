package nl.trydev07.betterkitpvp.utilitys.filemanager;


import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

/* TryDev07 created on 12/7/2019
 * Project:  Defaults
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class UtilFile implements InterfaceYmlFile {
    private JavaPlugin plugin;
    private File f;
    private FileConfiguration fc;

    public UtilFile(JavaPlugin plugin, File f, FileConfiguration fc) {
        this.plugin = plugin;
        this.f = f;
        this.fc = fc;
    }

    @Override
    public void create(String filename, boolean saveResource) {
        f = new File(plugin.getDataFolder(), filename);
        fc = new YamlConfiguration();

        if (!f.exists()) {
            f.getParentFile().mkdirs();

            if (saveResource == false) {
                try {
                    f.createNewFile();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {
                if (plugin.getResource(filename) == null) {
                    plugin.saveResource(filename, true);
                } else {
                    plugin.saveResource(filename, false);
                }
            }

            load();
        }
    }

    @Override
    public void load() {
        try {
            fc.load(f);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void save() {
        try {
            fc.save(f);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void set(String path, Object s) {
        fc.set(path, s);
        load();
    }

}
