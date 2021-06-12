package jp.simplespace.lazeronigokko;

import jp.simplespace.lazeronigokko.Listener.ParticleListener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class LazerOnigokko extends JavaPlugin {

    public static Plugin plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin=this;
        getServer().getPluginManager().registerEvents(new ParticleListener(),this);
        getLogger().info("プラグインを読み込んだよ☆");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("プラグインが去ったよ☆");
    }
}
