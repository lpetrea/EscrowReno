package org.deppar.viewer;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.layout.Pane;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import javax.swing.*;
import java.util.concurrent.CountDownLatch;

/**
 * Created by mslpe on 04.11.2015.
 */
public class JavaFXThreadingRule implements TestRule {

    /**
     * Flag for setting up the JavaFX, we only need to do this once for all tests.
     */
    private static boolean jfxIsSetup;

    @Override
    public Statement apply(Statement statement, Description description) {

        return new OnJFXThreadStatement(statement);
    }

    private static class OnJFXThreadStatement extends Statement {

        private final Statement statement;

        public OnJFXThreadStatement(Statement aStatement) {
            statement = aStatement;
        }

        private Throwable rethrownException = null;

        @Override
        public void evaluate() throws Throwable {

            if(!jfxIsSetup) {
                setupJavaFX();

                jfxIsSetup = true;
            }

            statement.evaluate();
        }

        protected void setupJavaFX() throws InterruptedException {

            long timeMillis = System.currentTimeMillis();

            final CountDownLatch latch = new CountDownLatch(1);

            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    // initializes JavaFX environment
                    new JFXPanel();

                    latch.countDown();
                }
            });

            System.out.println("javafx initialising...");
            latch.await();
            System.out.println("javafx is initialised in " + (System.currentTimeMillis() - timeMillis) + "ms");
        }
    }
}
