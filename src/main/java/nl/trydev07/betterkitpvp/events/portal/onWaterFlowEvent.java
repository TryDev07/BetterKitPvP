package nl.trydev07.betterkitpvp.events.portal;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;

/* TryDev07 created on 12/10/2019
 * Project:  BetterKitPvP 
 * Copyright to TryDev07 ©
 * Github: https://github.com/TryDev07
 */
public class onWaterFlowEvent implements Listener {

    public static Boolean FLOW = true;
    @EventHandler
    public void onBlockFromTo(BlockFromToEvent event) {
        if(FLOW == false) {
            int id = event.getBlock().getTypeId();
            if(id == 8 || id == 9) {
                event.setCancelled(true);
            }
        }
    }
}
