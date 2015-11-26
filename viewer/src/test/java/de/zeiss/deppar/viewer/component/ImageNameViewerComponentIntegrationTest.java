package de.zeiss.deppar.viewer.component;

import de.zeiss.deppar.viewer.JavaFXThreadingRule;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import org.junit.*;

/**
 * Created by mslpe on 04.11.2015.
 */
public class ImageNameViewerComponentIntegrationTest {

    @ClassRule public static JavaFXThreadingRule javaFxRule= new JavaFXThreadingRule();

    private ImageNameViewerComponent imageNameViewerComponent = new ImageNameViewerComponent();
    private StringProperty imageName = new SimpleStringProperty();

    @Test
    public void testBindImageToName() throws Exception {

                    imageNameViewerComponent.imageNameProperty().bind(imageName);

                    imageName.setValue("dog");

                    Image dogImage1 = imageNameViewerComponent.getNode().getImage();

                    imageName.setValue("cat");

                    Image catImage1 = imageNameViewerComponent.getNode().getImage();

                    imageName.setValue("dog");

                    Image dogImage2 = imageNameViewerComponent.getNode().getImage();

                    imageName.setValue("cat");

                    Image catImage2 = imageNameViewerComponent.getNode().getImage();

                    Assert.assertEquals(dogImage1, dogImage2);
                    Assert.assertEquals(catImage1, catImage1);
    }
}