package jp.simplespace.lazeronigokko;

import jp.simplespace.lazeronigokko.Commands.Setup;
import jp.simplespace.lazeronigokko.GUI.Gui;
import jp.simplespace.lazeronigokko.GUI.GuiListener;
import jp.simplespace.lazeronigokko.Listener.JoinLeaveListener;
import jp.simplespace.lazeronigokko.Listener.NormalLazerListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
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
        PluginManager pm = getServer().getPluginManager();
        //コンフィグ処理
        saveDefaultConfig();
        config = getConfig();
        //コマンド登録
        getCommand("setup").setExecutor(new Setup());
        getCommand("gui").setExecutor(new jp.simplespace.lazeronigokko.Commands.Gui());
        //コマンドタブ補完登録
        getCommand("setup").setTabCompleter(new Setup());
        getCommand("gui").setTabCompleter(new jp.simplespace.lazeronigokko.Commands.Gui());
        //初期化処理
        Gui.init();
        for(Player player : Bukkit.getOnlinePlayers()){
            player.kickPlayer(prefix+"プラグインが読み込み、若しくは再読み込みされたため、\nあなたはキックされました。");
        }
        //リスナー登録
        pm.registerEvents(new NormalLazerListener(),this);
        pm.registerEvents(new JoinLeaveListener(),this);
        pm.registerEvents(new GuiListener(),this);
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
