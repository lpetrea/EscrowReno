package de.zeiss.deppar.viewer.component;

import de.zeiss.deppar.viewer.JavaFXThreadingRule;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by mslpe on 16.11.2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class ImageNameViewerComponentTest {

    @ClassRule
    public static JavaFXThreadingRule javaFxRule = new JavaFXThreadingRule();

    @Mock
    private Map<String, Image> imageMap;

    @Mock(answer = Answers.CALLS_REAL_METHODS)
    SimpleStringProperty imageName;

    @InjectMocks
    private  ImageNameViewerComponent imageNameViewerComponent;

    @Mock
    Image dog;

    @Test
    public void testBindImageToName() throws Exception {

        when(imageMap.get("dog")).thenReturn(dog);

        imageNameViewerComponent.setImageName("dog");

        verify(imageMap).get("dog");
        assertEquals(imageNameViewerComponent.getNode().getImage(), dog);
    }
}