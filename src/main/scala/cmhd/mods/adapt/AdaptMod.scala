package cmhd.mods.adapt

import cmhd.mods.adapt.Util._
import cmhd.mods.adapt.command.ReloadCommand
import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.event.{FMLPreInitializationEvent, FMLServerStartingEvent}

@Mod(modid = AdaptMod.ModId, name = AdaptMod.ModName, version = AdaptMod.ModVersion, modLanguage = "scala")
object AdaptMod {
  final val ModId = "adapt"
  final val ModName = "Adapt"
  final val ModVersion = "0.0.0"

  @EventHandler
  def onPreInit(event: FMLPreInitializationEvent): Unit = {
    log = event.getModLog
  }

  @EventHandler
  def onServerStarting(event: FMLServerStartingEvent): Unit = {
    event.registerServerCommand(ReloadCommand)
  }
}
