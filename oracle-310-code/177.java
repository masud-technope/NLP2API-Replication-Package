package org.kodejava.example.script;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class ImportPackageExample {
    public static void main(String[] args) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByExtension("js");

        try {
            engine.eval(getScript());
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

    private static String getScript() {
        StringBuilder sb = new StringBuilder();
        sb.append("importPackage(java.util);");
        sb.append("");
        sb.append("var today = new Date();");
        sb.append("println('Today is ' + today);");
        return sb.toString();
    }
}