package org.deppar.viewer.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.TypeLiteral;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;
import org.deppar.viewer.JavaFXThreadingRule;
import org.junit.ClassRule;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by mslpe on 07.12.2015.
 */
public class TestViewerTest {

    @ClassRule
    public static JavaFXThreadingRule javaFxRule = new JavaFXThreadingRule();

    Injector injector = Guice.createInjector(new ViewerModule(), new AbstractModule() {
        @Override
        protected void configure() {
            bind(new TypeLiteral<Property<String>>(){}).to(SimpleStringProperty.class);
        }
    });

    @Test public void getNode() {

        TestViewer testViewer = injector.getInstance(TestViewer.class);

        assertNotNull(testViewer.getViewer().getNode());
    }
}
