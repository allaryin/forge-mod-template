package com.example.examplemod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod
{
    static final Minecraft MC = Minecraft.getMinecraft();

    static final String  MODID   = "ExampleMod";
    static final String  VERSION = "1.0.0";
    static final Logger  LOGGER  = LogManager.getFormatterLogger(MODID);
    static final Boolean DEV     = Boolean.parseBoolean( System.getProperty("development", "false") );

    static File          BaseDir;
    static Configuration Config;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        BaseDir = new File(event.getModConfigurationDirectory(), MODID);
        Config  = new Configuration( event.getSuggestedConfigurationFile() );

        if ( !BaseDir.exists() )
            BaseDir.mkdir();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // Need events? Uncomment these:
        //MinecraftForge.EVENT_BUS.register(this);
        //FMLCommonHandler.instance().bus().register(this);
        //LOGGER.debug("Registered events");

        LOGGER.info("Loaded version %s", VERSION);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }
}
