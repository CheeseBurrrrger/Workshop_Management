package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ControllerHomeEtc implements Initializable{
	private Stage stage;
    private Scene scene;
	@FXML
    private Label labelGreeting;

    @FXML
    private Button servicePanel;

    @FXML
    private Button sparepartPanel;

    @FXML
    private Button exitPanel;

    @FXML
    private Button salesPanel;

    @FXML
    private Button service;

    @FXML
    private Button sales;

    @FXML
    private Button sparepart;

    @FXML
    private Button sparepartIn;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		labelGreeting.setText("Halo "+Controller.getCurrentUser().getNamaUser());
	}
    @FXML
    public void sparepartPanelButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SparepartInPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
	
    @FXML
    public void exitButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void serviceButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ServiceDataInPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void sparepartButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SparepartInPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void historypanel(ActionEvent event)throws IOException{
    	Parent root = FXMLLoader.load(getClass().getResource("HistoryPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}