package jp.simplespace.lazeronigokko.GUI;

import jdk.jfr.Description;
import jp.simplespace.lazeronigokko.GUI.Menu.GunSelect;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Gui {
    private static final Map<Player,GuiType> mode = new HashMap<>();

     static void setGuiMode(Player player, GuiType type){
         mode.put(player,type);
    }
     static boolean isGuiMode(Player player,GuiType type){
         return mode.get(player).equals(type);
     }
     static GuiType getGuiMode(Player player){
         return mode.get(player);
     }
     static List<Player> getListPlayers(){
         return new ArrayList<>(mode.keySet());
     }

    /**
     * プレイヤーの初期値を設定する。(初期値=NONE)
     * @param player
     */
    public static void initPlayer(Player player){
         setGuiMode(player,GuiType.NONE);
     }
    public static void init() {
        GunSelect.init();
    }
}

