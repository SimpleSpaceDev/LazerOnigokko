package jp.simplespace.lazeronigokko;

import jp.simplespace.lazeronigokko.Commands.Setup;
import jp.simplespace.lazeronigokko.Listener.NormalLazerListener;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class LazerOnigokko extends JavaPlugin {

    private static Plugin plugin;
    public static FileConfiguration config;
    public static String prefix = ChatColor.RED + "" + ChatColor.BOLD + "[LO] " + ChatColor.RESET;
    public static String noPermission = prefix+ChatColor.RED+"実行する権限がありません。";

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin=this;
        //コンフィグ処理
        saveDefaultConfig();
        config = getConfig();
        //コマンド登録
        getCommand("setup").setExecutor(new Setup());
        //コマンドタブ補完登録
        getCommand("setup").setTabCompleter(new Setup());
        //リスナー登録
        getServer().getPluginManager().registerEvents(new NormalLazerListener(),this);
        getLogger().info("プラグインを読み込んだよ☆");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("プラグインが去ったよ☆");
    }
    public static Plugin getPlugin(){
        return plugin;
    }
    public static String getPrefix() {
        return prefix;
    }
}
