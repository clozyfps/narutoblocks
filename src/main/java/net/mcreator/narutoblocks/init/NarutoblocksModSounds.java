
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.narutoblocks.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.narutoblocks.NarutoblocksMod;

public class NarutoblocksModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, NarutoblocksMod.MODID);
	public static final RegistryObject<SoundEvent> HANDSIGN = REGISTRY.register("handsign", () -> new SoundEvent(new ResourceLocation("narutoblocks", "handsign")));
	public static final RegistryObject<SoundEvent> JUTSU = REGISTRY.register("jutsu", () -> new SoundEvent(new ResourceLocation("narutoblocks", "jutsu")));
	public static final RegistryObject<SoundEvent> POOF = REGISTRY.register("poof", () -> new SoundEvent(new ResourceLocation("narutoblocks", "poof")));
}
