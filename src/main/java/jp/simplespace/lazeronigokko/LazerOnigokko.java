package jp.simplespace.lazeronigokko;

import org.bukkit.plugin.java.JavaPlugin;

public final class LazerOnigokko extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("プラグインを読み込んだよ☆");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("プラグインが去ったよ☆");
    }
}
