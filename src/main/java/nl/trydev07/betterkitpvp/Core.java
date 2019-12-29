package nl.trydev07.betterkitpvp;

import nl.trydev07.betterkitpvp.command.CommandLoader;
import nl.trydev07.betterkitpvp.events.EventLoader;
import nl.trydev07.betterkitpvp.handlers.GUIHandler;
import nl.trydev07.betterkitpvp.handlers.LocationHandler;
import nl.trydev07.betterkitpvp.handlers.NPCHandler;
import nl.trydev07.betterkitpvp.handlers.PortalHandler;
import nl.trydev07.betterkitpvp.utilitys.FileManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

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
        super.onEnable();
        instance = this;
        fileManager = new FileManager(instance);
        fileManager.getConfig("Messages.yml").copyDefaults(true).save();

        new CommandLoader();
        new EventLoader();
        new LocationHandler().loadLocations();

        File folder = new File(Core.getInstance().getDataFolder() + "\\Data\\Portals\\");
        if (folder.exists() == true) {
            File[] listOfFiles = folder.listFiles();
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    PortalHandler portalHandler = new PortalHandler();
                    portalHandler.Create(listOfFiles[i].getName().replaceAll(".json", ""));
                    portalHandler.loadPortals();
                }
            }
        }

        File npcFolder = new File(Core.getInstance().getDataFolder() + "\\Data\\NPC\\");
        if (npcFolder.exists() == true) {
            File[] listOfFiles = npcFolder.listFiles();
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    NPCHandler NPCHandler = new NPCHandler(listOfFiles[i].getName().replaceAll(".json", ""));
                    NPCHandler.load();
                }
            }
        }


    }

    @Override
    public void onDisable() {

        LocationHandler.getLocationHandler().save();
        for (String string : PortalHandler.getPortalHandlerMap().keySet()) {
            PortalHandler.getPortalHandler(string).save();
        }
        for (String npc : NPCHandler.getNPCHandler().keySet()) {

            NPCHandler.getNpcHandler(npc, null).save();
        }
        for (String npc : GUIHandler.getGUIHandlerMap().keySet()) {

            GUIHandler.getGUI(npc).saveGUI();

        }

    }

    public static FileManager getFileManager() {
        return fileManager;
    }

    public static Core getInstance() {
        return instance;
    }
}
