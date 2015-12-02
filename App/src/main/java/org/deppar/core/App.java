package org.deppar.core;

import org.deppar.viewer.Viewer;
import org.deppar.viewer.ViewerFactory;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.MissingResourceException;
import java.util.ServiceLoader;
import java.util.concurrent.CompletableFuture;

import static java.util.Optional.ofNullable;
import static java.util.ServiceLoader.load;
import static java.util.concurrent.CompletableFuture.supplyAsync;

/**
 * Created by mslpe on 25.09.2015.
 */
public class App extends Application {


    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        CompletableFuture<Void> startAppFuture = supplyAsync(() -> loadViewerFactory())
                .thenAcceptAsync(viewerFactory -> startApp(primaryStage, viewerFactory), Platform::runLater);

        startAppFuture.whenCompleteAsync((rez, ex) -> ofNullable(ex)
                .ifPresent(e -> System.out.println("Cannot run app " + e)));
    }

    private ViewerFactory loadViewerFactory() {
        
        ServiceLoader<ViewerFactory> viewerFactoryLoader = load(ViewerFactory.class);

        if (viewerFactoryLoader.iterator().hasNext()) {

            return viewerFactoryLoader.iterator().next();

        } else {

            throw new MissingResourceException("No service implementation found for ViewerFactory interface", "ViewerFactory", "ViewerFactory");
        }
    }

    private void startApp(Stage primaryStage, ViewerFactory viewerFactory) {

        ChoiceBox<String> choiceBox = createChoiceBox();

        Viewer viewer = viewerFactory.create(choiceBox.valueProperty());

        Scene scene = createScene(choiceBox, viewer);

        prepStage(primaryStage, scene);
    }

    private ChoiceBox<String> createChoiceBox() {

        ChoiceBox<String> choiceBox = new ChoiceBox<>(FXCollections.observableArrayList("dog", "cat"));
        choiceBox.setValue("dog");

        return choiceBox;
    }

    private Scene createScene(ChoiceBox<String> choiceBox, Viewer viewer) {

        StackPane root = new StackPane();

        HBox hBox = new HBox();
        hBox.getChildren().add(choiceBox);
        hBox.getChildren().add(viewer.getNode());

        root.getChildren().addAll(hBox);

        return new Scene(root, 600, 500);
    }

    private void prepStage(Stage primaryStage, Scene scene) {

        primaryStage.setTitle("Viewer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
