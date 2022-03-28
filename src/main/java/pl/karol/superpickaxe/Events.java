package pl.karol.superpickaxe;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Events implements Listener {

    @EventHandler
    public void onBreakBlock(BlockBreakEvent event) {
        Player player = (Player) event;
        List<Enchantment> possible = new ArrayList<Enchantment>();
        ItemStack item = player.getItemInUse();

        for(Enchantment ench : Enchantment.values()) {
            if(ench.canEnchantItem(item)) {
                possible.add(ench);
            }
        }

        if(possible.size() >=1) {
            Collections.shuffle(possible);

            Enchantment chosen = possible.get(0);
            item.addEnchantment(chosen, 1+(int)(Math.random() * ((chosen.getMaxLevel() - 1) + 1)));
        }
    }
}
