package de.guntram.mcmod.easiervillagertrading;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class ConfigData {

    public static final ClientConfig CLIENT;
    public static final ForgeConfigSpec CLIENT_SPEC;
    public static boolean shiftSwapped;

    static {
        final Pair<ClientConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ClientConfig::new);
        CLIENT_SPEC = specPair.getRight();
        CLIENT = specPair.getLeft();
    }

    public static void refreshClient() {

        shiftSwapped = CLIENT.shiftSwapped.get();

    }

    public static class ClientConfig {

        public final ForgeConfigSpec.BooleanValue shiftSwapped;

        ClientConfig(ForgeConfigSpec.Builder builder) {

            builder.push("general");
            shiftSwapped = builder.comment("Make 'trade all' default").translation("easiervillagertrading.config.tt.swapshift").define("shiftSwapped", false);
            builder.pop();

        }
    }
}
