package de.zeiss.deppar.viewer.guice;

import com.google.inject.assistedinject.Assisted;
import de.zeiss.deppar.viewer.Viewer;
import de.zeiss.deppar.viewer.component.ImageNameViewerComponent;
import javafx.beans.property.Property;
import javafx.beans.property.StringProperty;
import javafx.scene.Node;

import javax.inject.Inject;

/**
 * Created by mslpe on 25.09.2015.
 */
public class ImageNameViewer implements Viewer {

    private ImageNameViewerComponent imageNameViewerComponent;

    @Inject
    public ImageNameViewer(ImageNameViewerComponent imageNameViewerComponent, @Assisted Property<String> name) {

        this.imageNameViewerComponent = imageNameViewerComponent;

        imageNameViewerComponent.imageNameProperty().bind(name);
    }

    public Node getNode() {
        return imageNameViewerComponent.getNode();
    }
}
