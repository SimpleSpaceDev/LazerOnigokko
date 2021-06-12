package jp.simplespace.lazeronigokko.Listener;

import jp.simplespace.lazeronigokko.Util.Lazer;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class ParticleListener implements Listener {

    public void onMovePlayer(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        Lazer.spawnParticle(p.getWorld(),p.getLocation());
    }
    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (e.getAction().equals(Action.RIGHT_CLICK_AIR)&&e.getItem().getType().equals(Material.REDSTONE)){
            Location loc = p.getEyeLocation().clone().add(p.getEyeLocation().getDirection());
            for(int i=0;i<10;i++){
                loc.add(p.getEyeLocation().getDirection());
                Lazer.spawnParticle(p.getWorld(),loc);
            }
        }
    }
}
