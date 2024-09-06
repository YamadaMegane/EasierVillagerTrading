package de.guntram.mcmod.easiervillagertrading;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class ConfigData {

    public static final ClientConfig CLIENT;
    public static final ForgeConfigSpec CLIENT_SPEC;
    public static boolean shiftSwapped;
    public static int tradeLimit;

    static {
        final Pair<ClientConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ClientConfig::new);
        CLIENT_SPEC = specPair.getRight();
        CLIENT = specPair.getLeft();
    }

    public static void refreshClient() {

        shiftSwapped = CLIENT.shiftSwapped.get();
        tradeLimit = CLIENT.tradeLimit.get();

    }

    public static class ClientConfig {

        public final ForgeConfigSpec.BooleanValue shiftSwapped;
        public final ForgeConfigSpec.IntValue tradeLimit;

        ClientConfig(ForgeConfigSpec.Builder builder) {

            builder.push("general");
            shiftSwapped = builder.comment("Make 'trade all' default").translation("easiervillagertrading.config.tt.swapshift").define("shiftSwapped", false);
            tradeLimit = builder.comment("Items per 'trade all'").translation("easiervillagertrading.config.tt.tradelimit").defineInRange("tradeLimit", 64, 1, 2304);
            builder.pop();

        }
    }
}
