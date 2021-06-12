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
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import static jp.simplespace.lazeronigokko.LazerOnigokko.plugin;

public class ParticleListener implements Listener {

    public void onMovePlayer(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        Lazer.spawnParticle(p.getWorld(),p.getLocation());
    }
    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (e.getAction().equals(Action.RIGHT_CLICK_AIR)&&e.getItem().getType().equals(Material.REDSTONE)){
            Vector vec = p.getEyeLocation().getDirection();
            Location loc = p.getEyeLocation().clone().add(vec);
            BukkitRunnable task = new BukkitRunnable(){
                int count = 10;
                public void run(){
                    if(count>0){
                        loc.add(vec);
                        Lazer.spawnParticle(p.getWorld(),loc);
                    }
                    else this.cancel();
                    count--;
                }
            };
            task.runTaskTimer(plugin,0L,1L);
            /**for(int i=0;i<10;i++){
                loc.add(p.getEyeLocation().getDirection());
                Lazer.spawnParticle(p.getWorld(),loc);
            }
             **/
        }
    }
}
