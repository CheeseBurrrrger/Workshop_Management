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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerServiceDataInPage implements Initializable{
	Stage stage;
	Scene scene;
	private static Services temp;
    public static Services getTemp() {
		return temp;
	}
	@FXML
    private Button homePanel;
    
    @FXML
    private Button servicePanel;
	
	@FXML
    private Button sparepartPanel;
    
    @FXML
    private Button exitPanel;
    
    @FXML
    private Button salesPanel;
    
    @FXML
    private Button submitButton;
    
    @FXML
    private ChoiceBox<String> merkMobil;
    
    @FXML
    private TextField vinMobil;
    
    @FXML
    private TextField modelMobil;
    
    @FXML
    private TextField mesinMobil;
    
    @FXML
    private TextField cc;
	
	@FXML
    private ChoiceBox<String> jenisMesin;
	
	@FXML
    private Label labelGreeting;
	
	 @FXML
	private Label labelPeringatan;
    
    private String[] mesin = {"Diesel","Bensin"};
    private String[] brand = {"AUDI","BMW","DAIHATSU","LEXUS","MERCEDES-BENZ","NISSAN","PEUGEOT","RENAULT","TOYOTA","VOLKSWAGEN","VOLVO"};

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		jenisMesin.getItems().addAll(mesin);
		merkMobil.getItems().addAll(brand);
		labelGreeting.setText("Halo "+Controller.getCurrentUser().getNamaUser());
	}
    public void exitButton(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void sparepartPanelButton(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("SparepartInPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void homeButton(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void submitButton(ActionEvent event)throws IOException{
    	labelPeringatan.setText("");
    	if(merkMobil.getValue()!=null&&vinMobil.getText()!=null&&modelMobil.getText()!=null&&mesinMobil.getText()!=null&&cc.getText()!=null&&jenisMesin.getValue()!=null) {
    		temp=new Services();
    		temp.doService(merkMobil.getValue(), vinMobil.getText(), modelMobil.getText(), mesinMobil.getText(), Integer.valueOf(cc.getText()), jenisMesin.getValue());
    		Parent root = FXMLLoader.load(getClass().getResource("ServiceWorkPage.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    	}else {
    		labelPeringatan.setText("Lengkapi seluruh kolom data!");
    	}
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