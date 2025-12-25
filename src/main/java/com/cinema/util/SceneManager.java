package com.cinema.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager {

    private static Stage stage;

    public static void setStage(Stage primaryStage) {
        stage = primaryStage;
    }

    public static void switchScene(String fxmlPath, String title) {
        try {
            Parent root = FXMLLoader.load(
                    SceneManager.class.getResource(fxmlPath)
            );

            Scene scene = new Scene(root, 900, 600);
            scene.getStylesheets().add(
                    SceneManager.class.getResource("/com/cinema/style/app.css")
                            .toExternalForm()
            );

            stage.setScene(scene);
            stage.setTitle(title);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
