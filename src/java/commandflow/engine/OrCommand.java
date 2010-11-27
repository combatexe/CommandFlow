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
package commandflow.engine;

import commandflow.Command;

/**
 * A short-circuit or command.
 * <p>
 * The command executes its contained commands in a sequence until the first command to return <code>true</code>. If no commands return <code>true</code> the command status is <code>false</code>. 
 * @author elansma
 */
public class OrCommand<C> extends CompositeCommand<C> {

    @Override
    public boolean execute(C context) {
        for (Command<C> command : getCommands()) {
            if (command.execute(context)) {
                return true;
            }
        }
        return false;
    }
    
}
