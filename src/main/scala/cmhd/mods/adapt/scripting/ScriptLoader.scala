package cmhd.mods.adapt.scripting

import java.io.{File, FileReader}

import cmhd.mods.adapt.Util._
import jdk.nashorn.api.scripting.NashornScriptEngineFactory

object ScriptLoader {
  def getScriptsDirectory = new File(getMinecraftDirectory, "adapt")

  def findScripts(dir: File): Array[File] = {
    if (!dirExistsOrMake(dir)) {
      log.fatal(s"${translateString("log.error.scripts_dir_missing")}: ${dir.getAbsolutePath}")
      return null
    }

    dir.listFiles.filter(f => !f.isDirectory && f.getName.endsWith(".js"))
  }

  def loadScript(file: File): Unit = {
    val factory = new NashornScriptEngineFactory
    val engine = factory.getScriptEngine(getEngineOptions)

    engine.eval(new FileReader(file))
  }

  def getEngineOptions = Array("-strict")
}
