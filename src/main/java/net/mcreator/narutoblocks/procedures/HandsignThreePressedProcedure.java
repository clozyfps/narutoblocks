package net.mcreator.narutoblocks.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class HandsignThreePressedProcedure {
public static void execute(
Entity entity
) {
if(
entity == null
) return ;
entity.getPersistentData().putBoolean("usingHandsign", true);entity.getPersistentData().putDouble("handsignTimer", 25);if (!().isEmpty()) {}else{}
}
}
