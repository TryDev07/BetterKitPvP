package nl.trydev07.betterkitpvp.events;

import nl.trydev07.betterkitpvp.Core;
import nl.trydev07.betterkitpvp.events.GUI.onNpcInventoryEvent;
import nl.trydev07.betterkitpvp.events.portal.onBlockBreakEvents;
import nl.trydev07.betterkitpvp.events.portal.onClickEvent;
import nl.trydev07.betterkitpvp.events.portal.onWalkInPortalEvent;
import nl.trydev07.betterkitpvp.events.portal.onWaterFlowEvent;
import org.bukkit.plugin.PluginManager;

/* TryDev07 created on 12/10/2019
 * Project:  BetterKitPvP 
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class EventLoader {

    public EventLoader(){
        PluginManager pluginManager = Core.getInstance().getServer().getPluginManager();

        pluginManager.registerEvents(new onBlockBreakEvents(), Core.getInstance());
        pluginManager.registerEvents(new onClickEvent(), Core.getInstance());
        pluginManager.registerEvents(new onWaterFlowEvent(), Core.getInstance());
        pluginManager.registerEvents(new onWalkInPortalEvent(), Core.getInstance());
        pluginManager.registerEvents(new onNpcInventoryEvent(), Core.getInstance());

    }
}
