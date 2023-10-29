
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.narutoblocks.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.narutoblocks.item.TestingItem;
import net.mcreator.narutoblocks.NarutoblocksMod;

public class NarutoblocksModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, NarutoblocksMod.MODID);
	public static final RegistryObject<Item> TESTING = REGISTRY.register("testing", () -> new TestingItem());
}
