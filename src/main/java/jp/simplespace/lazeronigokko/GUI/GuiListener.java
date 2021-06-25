package jp.simplespace.lazeronigokko.GUI;

import jp.simplespace.lazeronigokko.GUI.Menu.GunSelect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;

import static jp.simplespace.lazeronigokko.GUI.GuiType.NONE;

public class GuiListener implements Listener {
    @EventHandler
    public void onClickInventory(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        //Guiモードがなしだったらじゃなかったら
        if(Gui.isGuiMode(p, NONE)) return;
            e.setCancelled(true);
            switch(Gui.getGuiMode(p)){
                default:
                    return;
                case GUN_SELECT:
                    GunSelect.onClickInventory(e);
                    break;
            }
    }
    @EventHandler
    public void onOpenInventory(InventoryOpenEvent e){
        Inventory inv = e.getInventory();
        Player player = (Player) e.getPlayer();
        if(inv.equals(GunSelect.getInventory())){
            Gui.setGuiMode(player,GuiType.GUN_SELECT);
        }
        else{
            Gui.setGuiMode(player,GuiType.NONE);
        }
    }
    @EventHandler
    public void onCloseInventory(InventoryCloseEvent e) {
        Gui.setGuiMode((Player) e.getPlayer(),GuiType.NONE);
    }
}
