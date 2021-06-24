package jp.simplespace.lazeronigokko.Util;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Sounds {
    //完了音
    public static void playComplete(Player p){
        p.playSound(p.getLocation(),Sound.BLOCK_NOTE_BLOCK_PLING,1,21);
    }
}
