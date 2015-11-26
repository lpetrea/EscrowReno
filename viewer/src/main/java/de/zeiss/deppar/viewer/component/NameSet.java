package de.zeiss.deppar.viewer.component;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;

/**
 * Created by mslpe on 24.11.2015.
 */
public class NameSet extends HashSet<String> {

    private static final String IMAGE_PROPERTIES_FILE = "image.properties";
    private static final String IMAGE_NAMES_KEY = "image.names";

    private Properties imageProperties = new Properties();

    public NameSet() {

       loadImageNames();
    }

    protected void loadImageNames() {

        try (FileInputStream fis = new FileInputStream(getClass().getClassLoader().getResource(IMAGE_PROPERTIES_FILE).getFile())) {

            imageProperties.load(fis);

            String names = imageProperties.getProperty(IMAGE_NAMES_KEY);

            Boolean areAllAdded = Stream.of(names.split("\\s*,\\s*")).collect(collectingAndThen(Collectors.toSet(), this::addAll));

            if(!areAllAdded) {

                throw new IllegalStateException("Failed to read all the image names");
            }

        } catch (IOException e) {

            throw new IllegalStateException(e);
        }
    }
}
