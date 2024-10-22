package application;
import java.sql.Connection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Controller {
    private Stage stage;
    private Scene scene;
    Users gas = new Users();
    static Connection con=null;
    @FXML
    private Button buttonLogin;

    @FXML
    private TextField emailField;

    @FXML
    private TextField passwordField;

    @FXML
    private Label labelEmailTrue;

    @FXML
    private Label labelEmailFalse;

    @FXML
    private Label labelPasswordTrue;

    @FXML
    private Label labelPasswordFalse;

    @FXML
    private Label labelFailedLogin;
    
    @FXML
    private Label labelGreeting;
    
    @FXML
    private Label labelInfoOut;

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
    private Button service;

    @FXML
    private Button sales;

    @FXML
    private Button sparepart;

    @FXML
    private Button sparepartIn;

    @FXML
    private Button sparepartOut;
    @FXML
    private TextField partNumberOut;

    @FXML
    private TextField quantityOut;
    
    @FXML 
    private Button submitButton;

    private boolean emailFlag;
    private boolean passFlag;
    private static User user=null;

    public static void koneksi() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ED MOTOR","root","");
	}
    public static boolean melihatEmail(String email) throws SQLException, ClassNotFoundException {
		String data="";
	    koneksi();
	    String sql = "select *from `ED MOTOR`.user \r\n"
	    		+ "where emailUser = '"+email+"'";
	    Statement stmt = con.createStatement();
	    stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(sql);
	    while(rs.next()) {
	    	data=rs.getString("emailUser");
	    }
	    con.close();
	    if(data=="")return false;
	    else return true;	    
}
    public static boolean melihatPass(String pass)throws ClassNotFoundException, SQLException{
    	String data="";
	    koneksi();
	    String sql = "select *from `ED MOTOR`.user \r\n"
	    		+ "where passwordUser = '"+pass+"'";
	    Statement stmt = con.createStatement();
	    stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(sql);
	    while(rs.next()) {
	    	data=rs.getString("passwordUser");
	    }
	    con.close();
	    if(data=="")return false;
	    else return true;
    }
    public static String melihatUsername(String email)throws ClassNotFoundException, SQLException{
    	String data="";
	    koneksi();
	    String sql = "select *from `ED MOTOR`.user \r\n"
	    		+ "where emailUser = '"+email+"'";
	    Statement stmt = con.createStatement();
	    stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(sql);
	    while(rs.next()) {
	    	data=rs.getString("namaUser");
	    }
	    con.close();
	    return data;
    }
    @FXML
    public void emailEntry(ActionEvent e) {
        labelEmailTrue.setText("");
        labelEmailFalse.setText("");
        try {
            for (int i = 0; i < Users.getSize(); i++) {
                if (melihatEmail(emailField.getText())) {
                    labelEmailTrue.setText("Email ditemukan!");
                    emailFlag = true;
                    return;
                }
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        labelEmailFalse.setText("Email tidak ditemukan!");
    }
    @FXML
    public void passEntry(ActionEvent e) {
        labelPasswordTrue.setText("");
        labelPasswordFalse.setText("");
        try {
            for (int i = 0; i < Users.getSize(); i++) {
                if (melihatPass(passwordField.getText())) {
                    labelPasswordTrue.setText("Password benar!");
                    passFlag = true;
                    return;
                }
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        labelPasswordFalse.setText("Password salah!");
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
    public void sparepartPanelButton(ActionEvent event) throws IOException {
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
    public void loginButton(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
    	user=null;
        if (emailFlag && passFlag) {
        	for (int i = 0; i < Users.getSize(); i++) {
                if (melihatEmail(emailField.getText())) {
                    user=new User(melihatUsername(emailField.getText()), emailField.getText(), passwordField.getText());
                    break;
                }
        	}
            Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root); 
            stage.setScene(scene);
            stage.show();
        } else {
            labelFailedLogin.setText("Gagal Login!");
        }
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
	 public void submitButton(ActionEvent event)throws IOException, ClassNotFoundException, SQLException{
	    	koneksi();
	    	String sql = "update `ed motor`.part \r\n"
	    			+ "set PART.stok =stok -"+quantityOut.getText()+"\r\n"
	    			+ "where partNumber ="+partNumberOut.getText();
	    	Statement stmt = con.createStatement();		
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			labelInfoOut.setText("update success");
			System.out.println("update success");
	    }
    public static User getCurrentUser() {
    	return user;
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