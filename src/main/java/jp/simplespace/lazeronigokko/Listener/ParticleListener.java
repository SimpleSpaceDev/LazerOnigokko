package jp.simplespace.lazeronigokko.Listener;

import jp.simplespace.lazeronigokko.Util.Lazer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class ParticleListener implements Listener {
    @EventHandler
    public void onMovePlayer(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        Lazer.spawnParticle(p.getWorld(),p.getLocation());
    }
}
