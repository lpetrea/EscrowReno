package org.deppar.viewer.component;

import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by mslpe on 24.11.2015.
 */
public class ImageMap extends HashMap<String, Image> {

    private static final String IMAGE_DIR = "image/";
    private static final String IMAGE_EXT = ".jpg";

    public ImageMap(Set<String> keyNames) {

        loadImages(keyNames);
    }

    protected void loadImages(Set<String> keyNames) {

        keyNames.forEach(keyName -> put(keyName, new Image(IMAGE_DIR + keyName + IMAGE_EXT, true)));
    }
}
