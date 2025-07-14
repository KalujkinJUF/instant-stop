package com.kalujkin.instantstopmod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = InstantStopMod.MODID, name = InstantStopMod.NAME, version = InstantStopMod.VERSION)
public class InstantStopMod {
    public static final String MODID = "instantstopmod";
    public static final String NAME = "Instant Stop Mod";
    public static final String VERSION = "1.0";

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onInput(InputUpdateEvent event) {
        GameSettings settings = Minecraft.getMinecraft().gameSettings;

        if (!settings.keyBindForward.isKeyDown()
                && !settings.keyBindBack.isKeyDown()
                && !settings.keyBindLeft.isKeyDown()
                && !settings.keyBindRight.isKeyDown()) {

            event.getMovementInput().moveForward = 0;
            event.getMovementInput().moveStrafe = 0;

            Minecraft.getMinecraft().player.motionX = 0;
            Minecraft.getMinecraft().player.motionZ = 0;
        }
    }
}
