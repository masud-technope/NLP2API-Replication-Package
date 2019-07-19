package org.kodejava.example.script;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.io.File;
import java.io.Reader;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class EvalScriptFile {
    public static void main(String[] args) {
        //
        // Obtaining ECMAScript / JavaScript ScriptEngine.
        //
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("ECMAScript");

        try {
            //
            // Create an instance of File object that point to our
            // scripting file. An create a FileReader to read the
            // file to be passed to the ScriptEngine.eval() method.
            //
            // The file need to be placed in the same folder with
            // our class so it enable to read it. We can define the
            // full path to the file also to make easier for the
            // Reader to find it.
            //
            File script = new File("helloworld.js");
            Reader reader = new FileReader(script);

            engine.eval(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
