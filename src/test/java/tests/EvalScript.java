/**
 * Copyright 2010 Martin Lansler (elansma), Anders Jacobsson
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package tests;

import javax.script.Bindings;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.SimpleBindings;

public class EvalScript {
    public static void main(String[] args) throws Exception {
        String script = "name.length > 2 || name.length < 10";
        //
        // create a script engine manager
        ScriptEngineManager factory = new ScriptEngineManager();
        // create a JavaScript engine
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        CompiledScript compiledScript = null;
        if (engine instanceof Compilable) {
            System.out.println("Using compiled script...");
            Compilable compilable = (Compilable) engine;
            compiledScript = compilable.compile(script);
        }
        System.out.println(engine.getBindings(ScriptContext.GLOBAL_SCOPE).keySet());
        System.out.println(engine.getBindings(ScriptContext.ENGINE_SCOPE).keySet());

        System.out.println(engine.getFactory().getParameter("THREADING"));
        Bindings bindings = new SimpleBindings();
        bindings.put("name", "Martin");
        // evaluate JavaScript code from String
        Object result = compiledScript != null ? compiledScript.eval(bindings) : engine.eval(script, bindings);
        System.out.println(result);
    }
}