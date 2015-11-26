package de.zeiss.deppar.viewer;

import javafx.beans.property.Property;

/**
 * Created by mslpe on 25.09.2015.
 */
public interface ViewerFactory {

    //@Named("screen")

    Viewer create(Property<String> name);
}
