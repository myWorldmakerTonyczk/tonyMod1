package com.example.tonyMod1;

import com.example.tonyMod1.setup.ClientSetup;
import com.example.tonyMod1.setup.ModSetup;
import com.example.tonyMod1.setup.Registration;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod("tonyMod1")
public class tonyMod1 {

    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "tonyMod1";

    public tonyMod1(){

        Registration.init();

        IEventBus modbus = FMLJavaModLoadingContext.get().getModEventBus();
        modbus.addListener(ModSetup::init);
        DistExecutor.unsafeRunForDist(Dist.CLIENT , () ->  () -> modbus.addListener(ClientSetup::init););
    }
}