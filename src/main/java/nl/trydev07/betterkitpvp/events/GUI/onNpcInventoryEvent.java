package nl.trydev07.betterkitpvp.events.GUI;

import nl.trydev07.betterkitpvp.handlers.GUIHandler;
import nl.trydev07.betterkitpvp.handlers.NPCHandler;
import nl.trydev07.betterkitpvp.utilitys.LocationDeserializer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEntityEvent;

/* TryDev07 created on 29/12/2019
 * Project:  BetterKitPvP
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class onNpcInventoryEvent implements Listener {


    @EventHandler
    public void onNpcInventory(PlayerInteractEntityEvent event) {
        Player p = event.getPlayer();
        if (event.getRightClicked().getLocation().equals(LocationDeserializer.getLocationFromString(NPCHandler.getNpcHandler("Selector", p).getOobNpc().getLocation()))) {
            p.openInventory(GUIHandler.getGUI("Selector").getInventoryMap().get("test"));
        }
    }


    @EventHandler
    public void villDisableTrade(InventoryOpenEvent event) {
        if (event.getInventory().getType() == InventoryType.MERCHANT) {
            event.setCancelled(true);
        }
    }
}
