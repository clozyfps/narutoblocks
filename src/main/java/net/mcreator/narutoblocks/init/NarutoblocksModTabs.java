
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.narutoblocks.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class NarutoblocksModTabs {
	public static CreativeModeTab TAB_ARMOR;
	public static CreativeModeTab TAB_ITEMS;

	public static void load() {
		TAB_ARMOR = new CreativeModeTab("tabarmor") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(NarutoblocksModItems.LEAF_HEADBAND_HELMET.get());
			}

			@Override
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
		TAB_ITEMS = new CreativeModeTab("tabitems") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(NarutoblocksModItems.JUTSU_SCROLL.get());
			}

			@Override
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
	}
}
