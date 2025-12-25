package com.cinema.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import com.cinema.util.SceneManager;

import java.util.HashSet;
import java.util.Set;

public class SeatController {

    @FXML
    private GridPane seatGrid;

    @FXML
    private Label infoLabel;

    private final Set<Button> selectedSeats = new HashSet<>();

    @FXML
    public void initialize() {
        int rows = 5;
        int cols = 8;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                Button seat = new Button((char) ('A' + r) + "" + (c + 1));
                seat.setPrefSize(55, 40);
                seat.setStyle("-fx-background-color:#334155; -fx-text-fill:white;");

                seat.setOnAction(e -> toggleSeat(seat));
                seatGrid.add(seat, c, r);
            }
        }
    }

    private void toggleSeat(Button seat) {
        if (selectedSeats.contains(seat)) {
            selectedSeats.remove(seat);
            seat.setStyle("-fx-background-color:#334155; -fx-text-fill:white;");
        } else {
            selectedSeats.add(seat);
            seat.setStyle("-fx-background-color:#22c55e; -fx-text-fill:black;");
        }
        infoLabel.setText("Kursi dipilih: " + selectedSeats.size());
    }

    @FXML
    private void backToDetail() {
        SceneManager.switchScene(
                "/com/cinema/view/detail.fxml",
                "Detail Film"
        );
    }
}
