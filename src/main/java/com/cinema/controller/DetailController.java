package com.cinema.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import com.cinema.util.SceneManager;

public class DetailController {

    private static String filmImagePath;
    private static String filmTitle;

    @FXML
    private ImageView filmImage;

    @FXML
    private Label titleLabel;

    // DIPANGGIL DARI DASHBOARD
    public static void setFilmData(String imagePath, String title) {
        filmImagePath = imagePath;
        filmTitle = title;
    }

    @FXML
    public void initialize() {
        if (filmImagePath != null) {
            filmImage.setImage(
                    new Image(getClass().getResourceAsStream(filmImagePath))
            );
            titleLabel.setText(filmTitle);
        }
    }

    @FXML
    private void openSeat() {
        SceneManager.switchScene(
                "/com/cinema/view/seat.fxml",
                "Pilih Kursi"
        );
    }

    @FXML
    private void backToDashboard() {
        SceneManager.switchScene(
                "/com/cinema/view/dashboard.fxml",
                "Dashboard"
        );
    }


}
