package org.deppar.viewer.guice;

import javafx.beans.property.Property;
import org.deppar.viewer.Viewer;
import org.deppar.viewer.ViewerFactory;

import javax.inject.Inject;

/**
 * Created by mslpe on 07.12.2015.
 */
public class TestViewer {

    ViewerFactory viewerFactory;

    Property<String> imageName;

    Viewer viewer;

    @Inject
    public TestViewer(ViewerFactory viewerFactory, Property<String> imageName) {

        this.viewerFactory = viewerFactory;
        this.imageName = imageName;

        viewer = viewerFactory.create(imageName);
    }

    public Viewer getViewer() {

        return viewer;
    }

    public Viewer createViewer(Property<String> imageName) {

        return  viewerFactory.create(imageName);
    }

    public void setImageName(String imageName) {

        this.imageName.setValue(imageName);
    }
}
