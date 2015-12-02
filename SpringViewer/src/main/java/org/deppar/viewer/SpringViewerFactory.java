package org.deppar.viewer;

import org.deppar.viewer.spring.ViewerConfiguration;
import javafx.beans.property.Property;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by mslpe on 26.10.2015.
 */
public class SpringViewerFactory implements ViewerFactory {

    ApplicationContext context =
            new AnnotationConfigApplicationContext(ViewerConfiguration.class);

    @Override
    public Viewer create(Property<String> name) {

        return context.getBean(ViewerFactory.class).create(name);
    }
}
