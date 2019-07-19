package org.kodejava.example.script;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import javax.script.Invocable;

public class InvokingFunction {
    public static void main(String[] args) {
        String script =
            "function sayHello() {" +
            "   sayHello(null);" +
            "}" +
            " " +
            "function sayHello(name) {" +
            "   println('Hi there' + " +
            "       ((name == null) ? '!' : ' ' + name + '!'));" +
            "}";

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByExtension("js");

        try {
            engine.eval(script);

            //
            // Convert / cast the engine into invocable engine.
            //
            Invocable invocableEngine = (Invocable) engine;

            //
            // Invoking sayHello function without parameter.
            //
            invocableEngine.invokeFunction("sayHello");

            //
            // Invoking sayHello function with a parameter.
            //
            invocableEngine.invokeFunction("sayHello", "Jude");
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
