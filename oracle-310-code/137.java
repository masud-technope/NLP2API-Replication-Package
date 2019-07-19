import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;


public class JavaObjectDemo
{  
  public static void main(String[] args) throws Exception
  {
    ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine jsEngine;  
    jsEngine = manager.getEngineByExtension("js");
    jsEngine.eval("importPackage(javax.swing);var optionPane =JOptionPane.showMessageDialog(null, 'Hello!);");
  }
}
