package jp.simplespace.lazeronigokko.Commands;

import jp.simplespace.lazeronigokko.GUI.Menu.GunSelect;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static jp.simplespace.lazeronigokko.LazerOnigokko.prefix;

public class Gui implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(prefix+"このコマンドはプレイヤーしか実行できません。");
            return true;
        }
        Player p = (Player) sender;
        switch(args.length){
            default:
            case 0:
                p.sendMessage(getHelp());
                break;
            case 1:
                if(args[0].equalsIgnoreCase("gunselect")){
                    p.openInventory(GunSelect.getInventory());
                }
                else p.sendMessage(getHelp());
                break;
        }
        return true;
    }

    private static String getHelp(){
        StringBuilder text = new StringBuilder();
        text.append(ChatColor.BOLD+"ヘルプ\n");
        text.append("/gui gunselect");
        return text.toString();
    }

    @Nullable
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> commands = new ArrayList<>();
        //権限を持っていない場合nullを返す
        if(!sender.hasPermission("lazeronigokko.command.gui"))
            return null;

        //引数が1つのとき
        if (args.length == 1){
            commands.add("gunselect");
        }
        /**
        //引数が2つのとき
        else if (args.length == 2){
            //前の引数がレーザー距離のとき
            if (args[0].equalsIgnoreCase("gunselect")){
                commands.add("数値");
            }
        }
         */
        Collections.sort(commands);
        return commands;
    }
}
