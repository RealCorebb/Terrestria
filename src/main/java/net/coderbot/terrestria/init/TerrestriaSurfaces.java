package net.coderbot.terrestria.init;

import net.coderbot.terrestria.surface.BeachySurfaceBuilder;
import net.coderbot.terrestria.surface.CliffySurfaceBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class TerrestriaSurfaces {
	public static BeachySurfaceBuilder CALDERA_SURFACE;
	public static BeachySurfaceBuilder BASALT_SURFACE;
	public static CliffySurfaceBuilder CLIFF_SURFACE;
	public static TernarySurfaceConfig BASALT_CONFIG;

	public static void init() {
		CALDERA_SURFACE = Registry.register(Registry.SURFACE_BUILDER, "terrestria:caldera", new BeachySurfaceBuilder(TernarySurfaceConfig::deserialize, 100, v -> Blocks.SAND.getDefaultState()));

		BASALT_SURFACE = Registry.register(Registry.SURFACE_BUILDER, "terrestria:basalt", new BeachySurfaceBuilder(
				TernarySurfaceConfig::deserialize,
				63,
				v -> v > 1.0 ? TerrestriaBlocks.BASALT_SAND.getDefaultState() : Blocks.SAND.getDefaultState()
		));

		CLIFF_SURFACE = Registry.register(Registry.SURFACE_BUILDER, "terrestria:cliff", new CliffySurfaceBuilder(TernarySurfaceConfig::deserialize, 63));

		BASALT_CONFIG = new TernarySurfaceConfig (
				TerrestriaBlocks.BASALT_GRASS_BLOCK.getDefaultState(),
				TerrestriaBlocks.BASALT_DIRT.getDefaultState(),
				TerrestriaBlocks.BASALT_DIRT.getDefaultState()
		);
	}
}