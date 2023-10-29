
package net.mcreator.narutoblocks.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class JutsuScrollItem extends Item {
	public JutsuScrollItem() {
		super(new Item.Properties().tab(null).stacksTo(1).rarity(Rarity.COMMON));
	}
}
