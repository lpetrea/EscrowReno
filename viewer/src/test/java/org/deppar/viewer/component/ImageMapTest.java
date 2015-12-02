package org.deppar.viewer.component;

import org.deppar.viewer.JavaFXThreadingRule;
import javafx.scene.image.Image;

import org.junit.ClassRule;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by mslpe on 06.11.2015.
 */
public class ImageMapTest {

    @ClassRule public static JavaFXThreadingRule javaFxRule= new JavaFXThreadingRule();

    @Test public void loadImageMap() {

        Set<String> keys= new HashSet<>(Arrays.asList("dog"));

        ImageMap imageMap = new ImageMap(keys);

        assertEquals(Image.class, imageMap.get("dog").getClass());
    }
}