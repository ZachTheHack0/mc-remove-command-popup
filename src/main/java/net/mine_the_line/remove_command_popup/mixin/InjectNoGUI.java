package net.mine_the_line.remove_command_popup.mixin;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.*;
import net.fabricmc.api.*;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.network.packet.c2s.play.CommandExecutionC2SPacket;

@Environment(EnvType.CLIENT)
@Mixin(net.minecraft.client.network.ClientPlayNetworkHandler.class)
public class InjectNoGUI {
	@Overwrite
	public void runClickEventCommand(String command, @Nullable Screen afterActionScreen) {
		((ClientPlayNetworkHandler)(Object)this).sendPacket(new CommandExecutionC2SPacket(command));
        MinecraftClient.getInstance().setScreen(afterActionScreen);
	}
}