package me.poilet66.renamelore;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class LoreCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if(sender instanceof Player) {

            Player player = (Player) sender;
            if(player.hasPermission("renamelore.lore")) {

                if(player.getInventory().getItemInMainHand().getType() != Material.AIR) {

                    ItemStack item = player.getInventory().getItemInMainHand();
                    ItemMeta it = item.getItemMeta();
                    List<String> str = new ArrayList<>();

                    String lore = "";
                    for (int i = 0; i < args.length; i++) {
                        lore = lore + args[i] + " ";
                    }
                    lore = lore.strip();
                    lore = ChatColor.stripColor(lore);
                    str.add(ChatColor.GOLD + "" + ChatColor.ITALIC + lore);
                    it.setLore(str);
                    item.setItemMeta(it);
                }
                else {
                    player.sendMessage("§cYou aren't holding anything.");
                }
            }
            else {
                player.sendMessage("§cYou do not have permission for that command.");
            }

            return true;
        }

        return false;
    }
}
