package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerSparepartPage implements Initializable{
	Stage stage;
	Scene scene;
	static Connection con=null;
    @FXML
    private Button exitPanel;

    @FXML
    private TextField hargaIn;

    @FXML
    private Button homePanel;


    @FXML
    private TextField merkIn;

    @FXML
    private TextField namaIn;

    @FXML
    private TextField numberIn;

    @FXML
    private Button salesPanel;

    @FXML
    private Button servicePanel;

    @FXML
    private Button sparepartIn;

    @FXML
    private Button sparepartOut;

    @FXML
    private Button sparepartPanel;

    @FXML
    private TextField stokIn;

    @FXML
    private TextField tipeIn;

    @FXML
    private ComboBox<String> jenisIn;
    
    @FXML 
    private Button submitButton;
    @FXML
    private Label labelGreeting;
    @FXML
    private Label labelInfo;

    private String jenisPartIn[]= {"P","W","N"};
    @FXML
    public void sparepartButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SparepartInPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void sparepartOutButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SparepartOutPage.fxml"));
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
    public void homeButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		labelGreeting.setText("Halo "+Controller.getCurrentUser().getNamaUser());	
		jenisIn.getItems().addAll(jenisPartIn);
	}
	 public void submitButton(ActionEvent event)throws IOException, ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ED MOTOR","root","");
		int idPart=Part.cobaReturnIdPart();
		idPart++;
		String sql = "insert into `ed motor`.part values \r\n"
				+ "('"+idPart+"','"+namaIn.getText()+"','"+merkIn.getText()+"','"+tipeIn.getText()+"','"+jenisIn.getValue()+"','"+numberIn.getText()+"','"+hargaIn.getText()+"','"+stokIn.getText()+"')";
		Statement stmt = con.createStatement();		
		stmt = con.createStatement();
		stmt.executeUpdate(sql);
		labelInfo.setText("insert success");
		System.out.println("insert success");
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