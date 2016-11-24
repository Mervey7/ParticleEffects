package io.github.springhat.particleeffects;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class ParticleEffects extends JavaPlugin {

    private Logger logger;

    public void onEnable() {
        logger = getLogger();

        logger.info("Plugin enabled.");
    }

    public void onDisable() {
        logger.info("Plugin disabled.");
    }

}
