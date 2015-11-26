package de.zeiss.deppar.viewer.component;

import de.zeiss.deppar.viewer.Viewer;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Map;

import static javafx.beans.binding.Bindings.createObjectBinding;

/**
 * Created by mslpe on 25.09.2015.
 */
public class ImageNameViewerComponent implements Viewer {

    private Map<String, Image> imageMap;

    private final ImageView imageView = new ImageView();

    private final StringProperty imageName;

    public ImageNameViewerComponent() {

        this(new ImageMap(new NameSet()), new SimpleStringProperty());
    }

    public ImageNameViewerComponent(Map<String, Image> imageMap,  StringProperty imageName) {

        this.imageMap = imageMap;
        this.imageName = imageName;

        imageView.imageProperty().bind(mapImageNameToImage());
    }

    private ObjectBinding<Image> mapImageNameToImage() {

        return createObjectBinding(() -> imageMap.get(imageName.getValue()), imageName);
    }

    public String getImageName() {
        return imageName.get();
    }

    public StringProperty imageNameProperty() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName.set(imageName);
    }

    @Override
    public ImageView getNode() {

        return imageView;
    }
}
