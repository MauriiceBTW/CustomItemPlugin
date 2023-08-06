package me.maurice.customitemproject;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CustomItemCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (label.equalsIgnoreCase("customitem")) {

            if (!(sender instanceof Player)) {
                sender.sendMessage("This Command can only be executed ingame!");
                return true;
            }

            Player player = (Player) sender;

            if (args.length == 0) {
                if (player.getInventory().firstEmpty() == -1)
                    player.getWorld().dropItemNaturally(player.getLocation(), item());
                else
                    player.getInventory().addItem(item());
            }

        }

        return false;
    }

    private ItemStack item() {
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§a§lCustom §b§lSword");
        meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 5, true);
        meta.setUnbreakable(true);
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add("§7This is a custom Sword");
        lore.add("§7created in §6Episode 6");
        item.setItemMeta(meta);
        return item;
    }
}
