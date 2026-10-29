package com.nodeop;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;

/**
 * nodeop - lệnh /nodeop nhân bản món đồ đang cầm trên tay.
 *
 *   /nodeop          nhân bản thêm 1 bản (nguyên cả stack đang cầm)
 *   /nodeop <số>     nhân bản thêm <số> bản (1 đến 64)
 *
 * - Không cần quyền OP: ai cũng dùng được.
 * - Im lặng: không gửi bất kỳ thông báo nào trong chat.
 * - Chỉ người gõ lệnh nhận được đồ nhân bản.
 */
public class NodeOp implements ModInitializer {
    public static final String MOD_ID = "nodeop";
    private static final int MAX_COPIES = 64;

    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) ->
                dispatcher.register(Commands.literal("nodeop")
                        .requires(source -> true) // không cần quyền hạn
                        .executes(ctx -> duplicate(ctx.getSource(), 1))
                        .then(Commands.argument("times", IntegerArgumentType.integer(1, MAX_COPIES))
                                .executes(ctx -> duplicate(
                                        ctx.getSource(),
                                        IntegerArgumentType.getInteger(ctx, "times"))))));
    }

    private static int duplicate(CommandSourceStack source, int times) {
        ServerPlayer player = source.getPlayer();
        if (player == null) {
            return 0;
        }
        ItemStack held = player.getMainHandItem();
        if (held.isEmpty()) {
            return 0;
        }

        for (int i = 0; i < times; i++) {
            ItemStack copy = held.copy();
            // Túi đầy thì đồ rơi xuống chân người chơi
            if (!player.getInventory().add(copy) && !copy.isEmpty()) {
                player.drop(copy, false);
            }
        }
        // Trả về thành công nhưng KHÔNG gửi tin nhắn nào (sendSuccess không được gọi)
        return Command.SINGLE_SUCCESS;
    }
}
