
package net.mcreator.narutoblocks.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class TestingItem extends Item {
	public TestingItem() {
		super(new Item.Properties().tab(null).stacksTo(64).rarity(Rarity.COMMON));
	}
}
