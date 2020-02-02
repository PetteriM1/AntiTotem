package me.petterim1.antitotem;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerDeathEvent;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.inventory.PlayerInventory;
import cn.nukkit.inventory.PlayerOffhandInventory;
import cn.nukkit.item.ItemID;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.potion.Effect;

public class Main extends PluginBase implements Listener {

    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        PlayerInventory i1 = e.getEntity().getInventory();
        if (i1.getItem(i1.getHeldItemIndex()).getId() == ItemID.TOTEM) {
            i1.clear(i1.getHeldItemIndex());
        }
        PlayerOffhandInventory i2 = e.getEntity().getOffhandInventory();
        if (i2.getItem(0).getId() == ItemID.TOTEM) {
            i2.clear(0);
        }
    }
}
