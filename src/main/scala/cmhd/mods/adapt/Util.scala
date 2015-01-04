package cmhd.mods.adapt

import java.io.File

import net.minecraft.client.Minecraft
import net.minecraft.client.resources.I18n
import net.minecraft.util.ResourceLocation
import org.apache.logging.log4j.Logger

object Util {
  var log: Logger = null

  def dirExistsOrMake(dir: File) = dir.isDirectory && (dir.exists || dir.mkdirs())

  def getResourceStream(res: String) = getResource(res).getInputStream

  def getResource(res: String) = getResourceManager.getResource(getResourceLocation(res))

  def getResourceManager = getMinecraft.getResourceManager

  def getMinecraft = Minecraft.getMinecraft

  def getResourceLocation(res: String) = new ResourceLocation(AdaptMod.ModId, res)

  def getMinecraftDirectory = Minecraft.getMinecraft.mcDataDir

  def translateString(str: String) = I18n.format(str)
}
