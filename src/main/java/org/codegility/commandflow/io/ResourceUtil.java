/**
 * Copyright 2010/2011, Martin Lansler
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
package org.codegility.commandflow.io;

import java.io.InputStream;

/**
 * Util to load resources from the classpath
 * @author Martin Lansler
 */
public final class ResourceUtil {

    private ResourceUtil() {
    }

    /**
     * Loads a resource as a stream
     * @param parentPackage the package under which the resource is located
     * @param name the name of the resource
     * @return the resource stream
     * @throws ResourceNotFoundException if the resource was not found
     */
    public static InputStream getResourceAsStream(Package parentPackage, String name) {
        ClassPathResource resource = new ClassPathResource(parentPackage, name);
        return resource.getInputStream();
    }

}
