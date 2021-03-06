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
import java.net.URI;
import java.net.URISyntaxException;

/**
 * A classpath resource.
 * <p>
 * Search order for classpath resources are:
 * <ol>
 * <li>The classloader associated with this class, see {@link Class#getClassLoader()}</li>
 * <li>The classloader of the current thread, see {@link Thread#getContextClassLoader()}</li>
 * </ol>
 * @author Martin Lansler
 */
public class ClassPathResource extends AbstractResource {

    /**
     * Creates a new classpath resource.
     * @param uri classpath resource identifier
     */
    public ClassPathResource(URI uri) {
        super(uri);
    }

    /**
     * Creates a new classpath resource.
     * @param resource classpath resource, same syntax as {@link Class#getResourceAsStream(String)}.
     */
    public ClassPathResource(String resource) {
        try {
            setUri(new URI(resource));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Creates a new classpath resource
     * @param parentPackage the parent package
     * @param name the resource name under the parent directory
     */
    public ClassPathResource(Package parentPackage, String name) {
        this(String.format("%s/%s", parentPackage.getName().replace('.', '/'), name));
    }

    
    @Override
    public boolean exist() {
        return ClassPathResource.exist(getURI());
    }

    /**
     * Static form of {@link #exist()}.
     * @param resource the resource to check for existence
     * @return true if the resource exists
     */
    protected static boolean exist(URI uri) {
        String resource = uri.getSchemeSpecificPart();
        ClassLoader cl = ClassPathResource.class.getClassLoader();
        if (cl.getResource(resource) != null) {
            return true;
        }
        return Thread.currentThread().getContextClassLoader().getResource(resource) != null;

    }

    
    @Override
    public Resource resolveRelative(URI uri) {
        return new ClassPathResource(getURI().resolve(uri));
    }

    
    @Override
    public InputStream getInputStream() {
        String resource = getURI().getSchemeSpecificPart();
        ClassLoader cl = getClass().getClassLoader();
        InputStream is = cl.getResourceAsStream(resource);
        if (is != null) {
            return is;
        }
        cl = Thread.currentThread().getContextClassLoader();
        is = cl.getResourceAsStream(resource);
        if (is != null) {
            return is;
        }
        throw new ResourceNotFoundException("Could not find classpath resource '%s'", resource);
    }

    /**
     * A classpath resource resolver
     * @author Martin Lansler
     */
    public static class ClassPathResourceResolver implements ResourceResolver {
        /** The schema used for classpath resources */
        public static final String SCHEMA = "classpath";

        
        @Override
        public Resource resolve(URI uri) {
            return ClassPathResource.exist(uri) ? new ClassPathResource(uri) : null;
        }
    }
}
