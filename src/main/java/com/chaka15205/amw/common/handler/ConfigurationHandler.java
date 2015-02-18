package com.chaka15205.amw.common.handler;

import com.chaka15205.amw.common.util.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler {

    public static Configuration configuration;
    public static boolean testValue = false;
    public static void init(File configFile)
    {

        if (configuration == null) {

            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }
    private static void loadConfiguration() {

        testValue = configuration.getBoolean("configValue", Configuration.CATEGORY_GENERAL, false, "Enables or Disables Hard Recipes");
        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {

        if (event.modID.equalsIgnoreCase(Reference.ID)) {

            loadConfiguration();
        } else {
            System.out.println("Hi, Im Bob.   Not Really.");
        }
    }
}
