package org.maciejmarczak.cl.crud;

import org.maciejmarczak.cl.crud.config.RootConfig;
import org.maciejmarczak.cl.crud.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { RootConfig.class };
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebConfig.class };
    }

    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
