package io.github.neek_negoer.hextech;

import com.mojang.logging.LogUtils;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(Hextech.MOD_ID)
public class Hextech {
    public static final String MOD_ID = "hextech";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MOD_ID);

    public Hextech(IEventBus modEventBus) {
        REGISTRATE.registerEventListeners(modEventBus);

        // Phase 2+: register blocks, items, fluids, block entities here.
        // e.g. HextechBlocks.register(); HextechItems.register(); HextechFluids.register();

        LOGGER.info("Hextech initialized");
    }

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}
