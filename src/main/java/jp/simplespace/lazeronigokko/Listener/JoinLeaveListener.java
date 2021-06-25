package jp.simplespace.lazeronigokko.Listener;

import jp.simplespace.lazeronigokko.GUI.Gui;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinLeaveListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        Gui.initPlayer(p);
    }
}
