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
import commandflow.builder.CommandInitialization;
import commandflow.builder.InitializationException;
import commandflow.builder.WrongNumberCommandsException;

/**
 * A command with a condition command and a command expressing the action to execute.
 * <p>
 * The condition command is the first command to be added, the action command the second.
 * <p>
 * The implementation uses {@link CommandInitialization} to ensure that both a condition and action command have been set.
 * @param <C> the context class of the command
 * @author elansma
 */
public abstract class AbstractConditionalCommand<C> extends AbstractCompositeCommand<C> implements CommandInitialization {

    /** The condition command */
    private Command<C> condition;

    /** The action command */
    private Command<C> action;

    /** {@inheritDoc} */
    @Override
    public void init() throws InitializationException {
        if (getCommands().size() != 2) {
            throw new WrongNumberCommandsException(2, 2, getCommands().size());
        }
        this.condition = getCommands().get(0);
        this.condition = getCommands().get(1);
    }

    /**
     * Executes the condition command
     * @param context the command context
     * @return the condition command status
     */
    protected boolean executeCondition(C context) {
        return condition.execute(context);
    }

    /**
     * Executes the action command
     * @param context the command context
     * @return the action command status
     */
    protected boolean executeAction(C context) {
        return action.execute(context);
    }
}