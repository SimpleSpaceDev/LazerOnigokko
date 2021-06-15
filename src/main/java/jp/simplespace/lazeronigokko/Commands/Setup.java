package jp.simplespace.lazeronigokko.Commands;

import jp.simplespace.lazeronigokko.LazerOnigokko;
import org.apache.commons.lang.math.NumberUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static jp.simplespace.lazeronigokko.LazerOnigokko.*;

public class Setup implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        //コンソールからの実行の場合
        if(!(sender instanceof Player)){
            sender.sendMessage(getPrefix()+ ChatColor.RED+"このコマンドはプレイヤーのみが実行できます。");
            return true;
        }
        //通常時の処理
        Player p = (Player) sender;
        if(!(p.hasPermission("lazeronigokko.command.setup"))){
            p.sendMessage(noPermission);
            return true;
        }
        switch (args.length) {
            default:
            case 0:
            case 1:
                p.sendMessage(getHelp());
                break;
            case 2:
                //レーザーの距離の設定だったら
                if (args[0].equalsIgnoreCase("lazerdistance")){
                    //数値以外だったら
                    if(!NumberUtils.isNumber(args[1])){
                        p.sendMessage(getPrefix()+ChatColor.RED+"引数には数値を指定してください。");
                    }
                    //数値だったら
                    else {
                        config.set("lazer.distance",Integer.parseInt(args[1]));
                        p.sendMessage(getPrefix()+ChatColor.GREEN+"レーザーの発射距離を"+args[1]+"に設定しました。");
                        getPlugin().saveConfig();
                    }
                }
        }
        return true;
    }
    public static String getHelp(){
        return getPrefix()+"ヘルプは作成中だよ☆";
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> commands = new ArrayList<>();
        //権限を持っていない場合nullを返す
        if(!sender.hasPermission("lazeronigokko.command.setup"))
            return null;

        //引数が1つのとき
        if (args.length == 1){
            commands.add("lazerdistance");
        }
        //引数が2つのとき
        else if (args.length == 2){
            //前の引数がレーザー距離のとき
            if (args[0].equalsIgnoreCase("lazerdistance")){
                commands.add("数値");
            }
        }
        Collections.sort(commands);
        return commands;
    }
}
