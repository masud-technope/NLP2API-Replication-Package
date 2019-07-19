import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
//w  ww  . j av a2s . c  o  m
public class Main {
  public static void main(String[] args) {
    // Get the Nashorn engine
    ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine engine = manager.getEngineByName("JavaScript");

    String script = "print(msg)";
    try {
      engine.put("msg", "Hello from Java program");
      engine.eval(script);
    } catch (ScriptException e) {
      e.printStackTrace();
    }
  }
}