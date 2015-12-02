package org.deppar.viewer.spring;

import org.deppar.viewer.component.ImageNameViewerComponent;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.verify;

/**
 * Created by mslpe on 17.11.2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class ImageNameViewerTest {

    @Mock
    Map<String, Image> imageMap = new HashMap<>();

    @Mock
    SimpleStringProperty imageName = new SimpleStringProperty();

    @Mock
    SimpleStringProperty name;

    @Test
    public void testBind() {

        ImageNameViewerComponent imageNameViewerComponent = new ImageNameViewerComponent(imageMap, imageName);

        ImageNameViewer oneImageViewer = new ImageNameViewer(imageNameViewerComponent, name);

        verify(imageName).bind(name);
    }
}