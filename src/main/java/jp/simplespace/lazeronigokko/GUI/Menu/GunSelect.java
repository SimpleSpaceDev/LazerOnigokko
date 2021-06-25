package jp.simplespace.lazeronigokko.GUI.Menu;

import jp.simplespace.lazeronigokko.Items.LazerGun;
import jp.simplespace.lazeronigokko.Util.Sounds;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class GunSelect {
    private final static Inventory inv = Bukkit.createInventory(null,9, ChatColor.GREEN+""+ChatColor.BOLD+"レーザー銃の選択");;

    public static void init(){
        inv.clear();
        inv.addItem(new LazerGun());
    }
    public static boolean isContainsItem(ItemStack item){
        if(item == null) return false;
        if(new LazerGun().equals(item)) return true;

        return false;
    }
    public static Inventory getInventory(){
        return inv;
    }

    public static void onClickInventory(@NotNull InventoryClickEvent e){
        Player clicker = (Player) e.getWhoClicked();
        ItemStack item = e.getCurrentItem();
        e.setCancelled(true);
        if(isContainsItem(item)) {
            clicker.getInventory().addItem(item);
            Sounds.playComplete(clicker);
            clicker.closeInventory();
        }
    }
}
