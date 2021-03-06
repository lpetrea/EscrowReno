EscrowReno
EscrowReno aka upside-down WonderWorks - the building which is upside-down

When in Spring it's raining cats and dogs go drink a Guice.

Using dependency injection frameworks leads quickly into the following dependency problem: 
an object defined with wider scope depends on a object with a narrower scope,
e.g. a visual control that depends on a  value object created at runtime. This example presents
a viewer that displays one image at the time based on the name of the image given at runtime.

All I want to write is something like:

Property<String> imageName = new SimpleStringProperty("cat");
Viewer viewer = viewerFactory.create(imageName);

This type of problem can be solved by using the Factory pattern. Guice and Spring are chosen to
show how this solution is implemented. 
The GuiceViewer module provides the viewer written with Guice help. It makes use of a special feature called AssistedInject.
The SpringViewer module provides the viewer written with Spring help. It uses annotation based configuration.
The Viewer module provides the Viewer interface and common code for a basic implementation of a viewer component.
The App module is the application that uses the viewer to show the image selected by a choiceBox. The App can use the viewer provided 
by GuiceViewer xor SpringViewer. It loads the dependency at runtime by means of Java SPI. 

All I want in the application to write is:

Viewer viewer = viewerFactory.create(choiceBox.valueProperty());