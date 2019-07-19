import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ScriptExecutionReaderDemo {
  public static void main(String[] args) throws Exception {
    ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine jsEengine = manager.getEngineByExtension("js");
    Reader reader = new InputStreamReader(new FileInputStream("yourJavaScript.js"));
    jsEengine.eval(reader);
  }
}
//File yourJavaScript.js
/*
importPackage(java.lang);
function getName(name)
{
  if ((name != "")&&(name !=null))
  {  
    System.out.println("Hello "+name+"!")
  }
  else
  {   
    System.out.println("Hello!")
  }
}
getName("TOM");

*/