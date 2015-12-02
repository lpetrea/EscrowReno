package org.deppar.viewer;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.deppar.viewer.guice.ViewerModule;
import javafx.beans.property.Property;

/**
 * Created by mslpe on 26.10.2015.
 */
public class GuiceViewerFactory implements ViewerFactory {

    Injector injector = Guice.createInjector(new ViewerModule());

    public Viewer create(Property<String> name) {

        return injector.getInstance(ViewerFactory.class).create(name);
    }
}
