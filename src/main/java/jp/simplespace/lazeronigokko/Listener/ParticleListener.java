package jp.simplespace.lazeronigokko.Listener;

import jp.simplespace.lazeronigokko.Util.Lazer;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.data.type.GlassPane;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import static jp.simplespace.lazeronigokko.LazerOnigokko.config;
import static jp.simplespace.lazeronigokko.LazerOnigokko.getPlugin;

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
                int count = config.getInt("lazer.distance",50);
                public void run(){
                    if(count>0){
                        Material type = loc.getBlock().getType();
                        //水（レーザーが消える）
                        if (type == Material.WATER) {
                            this.cancel();
                            //貫通(空気・ガラス)
                        } else if (type == Material.AIR || type.name().contains("GLASS")) {
                            loc.add(vec);
                            //空気以外（ブロックなど）
                        } else {
                            loc.add(vec.multiply(-1));
                        }
                        Lazer.spawnParticle(p.getWorld(),loc);
                    }
                    else this.cancel();
                    count--;
                }
            };
            task.runTaskTimer(getPlugin(),0L,1L);
            /**for(int i=0;i<10;i++){
                loc.add(p.getEyeLocation().getDirection());
                Lazer.spawnParticle(p.getWorld(),loc);
            }
             **/
        }
    }
}
