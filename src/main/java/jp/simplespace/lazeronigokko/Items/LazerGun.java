package jp.simplespace.lazeronigokko.Items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class LazerGun extends ItemStack {

    public LazerGun(){
        super(Material.RED_DYE);
        initItem();
    }
    private void initItem(){
        ItemMeta meta = super.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW+"スタンダードレーザー銃");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE+"普通のレーザー銃だ（？）");
        meta.setLore(lore);
        this.setItemMeta(meta);
    }
}
