package cmhd.mods.adapt.command

import cmhd.mods.adapt.Util._
import net.minecraft.command.{CommandBase, ICommandSender}
import net.minecraft.util.ChatComponentTranslation

import scala.collection.JavaConversions._

object ReloadCommand extends CommandBase {
  override def getCommandName = "reload"

  override def getCommandAliases = "rl" :: Nil

  override def getCommandUsage(sender: ICommandSender) = "command.reload.usage"

  override def processCommand(sender: ICommandSender, args: Array[String]) = {
    sender.addChatMessage(new ChatComponentTranslation("command.reload.text"))
    log.info(translateString("command.reload.text"))

    // TODO Begin reload of scripting engine.
    // TODO Maybe propagate the sender so that we can display chat messages about the status.
  }
}
