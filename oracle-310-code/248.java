package org.kodejava.example.script;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class ModifiedJavaObjectFromScript {
    public static void main(String[] args) {
        //
        // Creating an array of five colors
        //
        List colors = new ArrayList();
        colors.add("White");
        colors.add("Black");
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        
        //
        // Obtain a ScriptEngine instance.
        //
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByExtension("js");

        //
        // Place the colors list into the engine using colorList key.
        // After setting the list into the engine our script will be
        // able to read it.
        //
        engine.put("colorList", colors);
        
        try {
            engine.eval(getScript());
            
            //
            // Redisplay the modified version of colors list object.
            //
            for (String color : colors) {
                System.out.println("Color = " + color);
            }
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

    private static String getScript() {
        //
        // Below is our script to read the values of Java List that
        // contains string of colors. We also add some other colors
        // to the list object in the script environment.
        //
        String script =
                "var index; " +
                "var colors = colorList.toArray(); " +
                " " +
                "for (index in colors) { " +
                "    println(colors[index]); " +
                "}" +
                " " +
                "colorList.add("Yellow"); " +
                "colorList.add("Purple"); " +
                "colorList.add("Orange"); ";
        return script;
    }
}
