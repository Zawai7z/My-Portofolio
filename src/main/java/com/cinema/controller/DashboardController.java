package com.cinema.controller;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import com.cinema.util.SceneManager;

public class DashboardController {

    @FXML
    private HBox filmContainer;

    @FXML
    public void initialize() {

        addFilm("/com/cinema/image/onepiece.jpg", "One Piece");
        addFilm("/com/cinema/image/kiminonawa.jpg", "Kimi No Na Wa");
        addFilm("/com/cinema/image/aot.jpg", "Attack On Titan");
    }

    private void addFilm(String imagePath, String title) {

        ImageView imageView = new ImageView(
                new Image(getClass().getResourceAsStream(imagePath))
        );
        imageView.setFitWidth(150);
        imageView.setFitHeight(220);
        imageView.setPreserveRatio(true);

        Label label = new Label(title);
        label.setStyle("-fx-text-fill:white; -fx-font-weight:bold;");

        VBox card = new VBox(10, imageView, label);
        card.setAlignment(Pos.CENTER);
        card.setStyle("""
            -fx-background-color: rgba(255,255,255,0.08);
            -fx-background-radius: 12;
            -fx-padding: 12;
            -fx-cursor: hand;
        """);

        card.setOnMouseClicked(e -> {
            DetailController.setFilmData(imagePath, title);
            SceneManager.switchScene(
                    "/com/cinema/view/detail.fxml",
                    "Detail Film"
            );
        });

        filmContainer.getChildren().add(card);
    }
}
