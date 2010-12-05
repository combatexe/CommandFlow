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

/**
 * A command that executes a list of commands in parallel.
 * @author elansma
 * @param <C> the context class of the command
 */
public class ParallelCommand<C> extends AbstractCompositeCommand<C> {

    @Override
    public boolean execute(C context) {
        // TODO Auto-generated method stub
        return false;
    }

}
