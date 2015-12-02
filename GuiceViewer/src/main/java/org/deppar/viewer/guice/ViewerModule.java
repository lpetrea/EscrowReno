package org.deppar.viewer.guice;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import org.deppar.viewer.Viewer;
import org.deppar.viewer.ViewerFactory;

/**
 * Created by mslpe on 25.09.2015.
 */
public class ViewerModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new FactoryModuleBuilder().implement(Viewer.class,
                /*Names.named("screen"),*/ ImageNameViewer.class).build(
                ViewerFactory.class));
    }
}
