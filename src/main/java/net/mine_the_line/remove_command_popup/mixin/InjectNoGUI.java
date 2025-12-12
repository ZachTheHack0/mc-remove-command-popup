package net.mine_the_line.remove_command_popup.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.network.protocol.game.ServerboundChatCommandPacket;

import org.jetbrains.annotations.Nullable;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Environment(EnvType.CLIENT)
@Mixin(net.minecraft.client.multiplayer.ClientPacketListener.class)
public class InjectNoGUI {
	@Overwrite
	public void sendUnattendedCommand(String command, @Nullable Screen afterActionScreen) {
		((ClientPacketListener)(Object)this).send(new ServerboundChatCommandPacket(command));
        Minecraft.getInstance().setScreen(afterActionScreen);
	}
}