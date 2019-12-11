package nl.trydev07.betterkitpvp.events.portal;

import nl.trydev07.betterkitpvp.handlers.LocationHandler;
import nl.trydev07.betterkitpvp.handlers.PortalHandler;
import nl.trydev07.betterkitpvp.handlers.oob.OOBPortal;
import nl.trydev07.betterkitpvp.utilitys.LocationDeserializer;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

/* TryDev07 created on 12/11/2019
 * Project:  BetterKitPvP
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class onWalkInPortalEvent implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        if (!event.getFrom().getBlock().getLocation().equals(event.getTo().getBlock().getLocation())) {
            if (PortalHandler.getPortalHandlerMap().keySet() != null) {
                for (PortalHandler portalHandler : PortalHandler.getPortalHandlerMap().values()) {
                    for (Location loc : portalHandler.getLocationList()) {
                        if (loc.equals(event.getTo().getBlock().getLocation())) {
                            event.getPlayer().teleport(LocationDeserializer.getLocationFromString(LocationHandler.getLocationHandler().OOBLocation.getSpawnLocation()));
                        }
                    }
                }
            }
        }

    }
}

