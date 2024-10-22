package application;

import java.sql.SQLException;
import java.sql.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
    private static final String FONT_CSS = "font.css";
    private static final String FONT_PATH = "Lato-Light.ttf";
    @Override
    public void start(Stage primaryStage) {
        try {
            Font font = Font.loadFont(getClass().getResourceAsStream(FONT_PATH), 10);
            if (font != null) {
                System.out.println("Font loaded successfully: " + font.getName());
            } else {
                System.out.println("Failed to load font.");
            }

            Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
            Scene scene = new Scene(root);
            applyFontCss(scene); // Apply the CSS to the initial scene
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        launch(args);
    }
    public static void applyFontCss(Scene scene) {
        scene.getStylesheets().add(Main.class.getResource(FONT_CSS).toExternalForm());
    }
}