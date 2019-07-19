import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;

public class ListEngines {
  public static void main(String args[]) {
    ScriptEngineManager manager = new ScriptEngineManager();
    List<ScriptEngineFactory> factories = manager.getEngineFactories();
    for (ScriptEngineFactory factory : factories) {
      System.out.println(factory.getEngineName());
      System.out.println(factory.getEngineVersion());
      System.out.println(factory.getLanguageName());
      System.out.println(factory.getLanguageVersion());
      System.out.println(factory.getExtensions());
      System.out.println(factory.getMimeTypes());
      System.out.println(factory.getNames());
    }
  }
}