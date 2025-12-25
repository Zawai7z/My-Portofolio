package com.cinema.controller;

import com.cinema.util.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleLogin() {

        String username = usernameField.getText();
        String password = passwordField.getText();

        // LOGIN SEDERHANA
        if (username.equals("1") && password.equals("1")) {

            System.out.println("Login berhasil");

            SceneManager.switchScene(
                    "/com/cinema/view/dashboard.fxml",
                    "Dashboard"
            );

        } else {
            System.out.println("Login gagal");
        }
    }
}
