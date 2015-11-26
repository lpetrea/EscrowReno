package de.zeiss.deppar.viewer.spring;

import de.zeiss.deppar.viewer.Viewer;
import de.zeiss.deppar.viewer.component.ImageNameViewerComponent;
import javafx.beans.property.Property;
import javafx.beans.property.StringProperty;
import javafx.scene.Node;

/**
 * Created by mslpe on 28.09.2015.
 */
public class ImageNameViewer implements Viewer {

    private ImageNameViewerComponent imageNameViewerComponent;

    protected ImageNameViewer(ImageNameViewerComponent imageNameViewerComponent, Property<String> name) {

        this.imageNameViewerComponent = imageNameViewerComponent;

        imageNameViewerComponent.imageNameProperty().bind(name);
    }

    public Node getNode() {

        return imageNameViewerComponent.getNode();
    }
}
