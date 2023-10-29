
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.narutoblocks.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.narutoblocks.item.TestingItem;
import net.mcreator.narutoblocks.item.JutsuScrollItem;
import net.mcreator.narutoblocks.item.FireBallJutsuRangedItem;
import net.mcreator.narutoblocks.NarutoblocksMod;

public class NarutoblocksModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, NarutoblocksMod.MODID);
	public static final RegistryObject<Item> JUTSU_SCROLL = REGISTRY.register("jutsu_scroll", () -> new JutsuScrollItem());
	public static final RegistryObject<Item> TESTING = REGISTRY.register("testing", () -> new TestingItem());
	public static final RegistryObject<Item> FIRE_BALL_JUTSU_RANGED = REGISTRY.register("fire_ball_jutsu_ranged", () -> new FireBallJutsuRangedItem());
}
