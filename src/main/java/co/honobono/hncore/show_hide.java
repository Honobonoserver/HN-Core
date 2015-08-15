package co.honobono.hncore;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import co.honobono.hncore.util.sendPacket;

public class show_hide implements CommandExecutor {
	private static Map<Player, Player> hiders= new HashMap<Player, Player>();

	public static Map<Player, Player> gethider() {
		return hiders;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(cmd.getName().equalsIgnoreCase("show")){
			Player player = (Player) sender;
			for (Player all : Bukkit.getOnlinePlayers()) {
				all.showPlayer(player);
			}
			sendPacket.sendActionBar((Player) sender, "§aShow!");
			hiders.remove(player);
			return true;
		} else if(cmd.getName().equalsIgnoreCase("hide")){
			Player player = (Player) sender;
			for (Player all : Bukkit.getOnlinePlayers()) {
				all.hidePlayer(player);
			}
			sendPacket.sendActionBar((Player) sender, "§aHide!");
			hiders.put(player,player);
			return true;
		} else {
			return false;
		}
	}
}