package de.zeiss.deppar.viewer.component;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by mslpe on 25.11.2015.
 */
public class NameSetTest {

    @Test
    public void loadNameSet() {

        Set<String> nameSet = new NameSet();

        assertTrue(nameSet.contains("dog"));
    }

}