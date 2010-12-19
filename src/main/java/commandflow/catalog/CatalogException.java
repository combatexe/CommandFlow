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
package commandflow.catalog;

/**
 * Unchecked exception for all exception raised by the catalog.
 * <p>
 * Note: This exception is only related to the catalog implementation itself and not to the runtime execution of commands handled by the catalog.
 * @author elansma
 */
public class CatalogException extends RuntimeException {
    /** Serial id */
    private static final long serialVersionUID = -6632328115517415046L;

    public CatalogException(Throwable cause, String message, Object... formattingArgs) {
        super(String.format(message, formattingArgs), cause);
    }

    public CatalogException(String message, Object... formattingArgs) {
        super(String.format(message, formattingArgs));
    }

    public CatalogException(Throwable cause) {
        super(cause);
    }

}
