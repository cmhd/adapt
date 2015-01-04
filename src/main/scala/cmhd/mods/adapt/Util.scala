package cmhd.mods.adapt

import java.io.File

import net.minecraft.client.Minecraft
import net.minecraft.client.resources.I18n
import net.minecraft.util.ResourceLocation
import org.apache.logging.log4j.Logger

object Util {
  var log: Logger = null

  def getResourceStream(resource: String) = getResource(resource).getInputStream

  def getResource(resource: String) = getResourceManager.getResource(getResourceLocation(resource))

  def getResourceManager = getMinecraft.getResourceManager

  def getMinecraft = Minecraft.getMinecraft

  def getResourceLocation(resource: String) = new ResourceLocation(AdaptMod.ModId, resource)

  def getScriptsDirectory = new File(getMinecraftDirectory, "adapt")

  def getMinecraftDirectory = Minecraft.getMinecraft.mcDataDir

  def translateString(string: String) = I18n.format(string)
}
