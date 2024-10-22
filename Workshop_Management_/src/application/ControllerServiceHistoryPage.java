package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ControllerServiceHistoryPage implements Initializable{
	
	private Stage stage;
    private Scene scene;
    private Parent root;
    static Connection con=null;
    static String sql=null;
    @FXML
    private ComboBox<String> comboBoxUrutkan;
    
    private String urutan[]= {"Merk ","Tanggal","Jenis Kerjaan","Kerjaan"};

    @FXML
    private Button exitPanel;

    @FXML
    private Button homePanel;
    @FXML
    private TableView<Service> tableViewServiceHistroy;
    @FXML
    private TableColumn<Service, Integer> kolomCCMesin;

    @FXML
    private TableColumn<Service, Integer> kolomIdService;

    @FXML
    private TableColumn<Service, String> kolomJenisKerjaan;

    @FXML
    private TableColumn<Service, String> kolomJenisMesin;

    @FXML
    private TableColumn<Service, String> kolomKerjaan;

    @FXML
    private TableColumn<Service, String> kolomKodeMesin;

    @FXML
    private TableColumn<Service, String> kolomMerkMobil;

    @FXML
    private TableColumn<Service, String> kolomNamaMobil;

    @FXML
    private TableColumn<Service, String> kolomTanggalMasuk;

    @FXML
    private TableColumn<Service, String> kolomVINMobil;

    @FXML
    private Label labelGreeting;

    @FXML
    private Button salesPanel;

    @FXML
    private Button servicePanel;

    @FXML
    private Button sparepartPanel;

    static ObservableList<Service> WorksHistory = FXCollections.observableArrayList();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		comboBoxUrutkan.getItems().addAll(urutan);
		try {
			getHistory();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		labelGreeting.setText("Halo "+Controller.getCurrentUser().getNamaUser());
		kolomIdService.setCellValueFactory(new PropertyValueFactory<>("id"));
		kolomMerkMobil.setCellValueFactory(new PropertyValueFactory<>("Merk"));
		kolomVINMobil.setCellValueFactory(new PropertyValueFactory<>("VIN"));
		kolomNamaMobil.setCellValueFactory(new PropertyValueFactory<>("namaMobil"));
		kolomKodeMesin.setCellValueFactory(new PropertyValueFactory<>("kodeMesin"));
		kolomJenisMesin.setCellValueFactory(new PropertyValueFactory<>("jenisMesin"));
		kolomCCMesin.setCellValueFactory(new PropertyValueFactory<>("ccMesin"));
		kolomJenisKerjaan.setCellValueFactory(new PropertyValueFactory<>("jenisKerjaan"));
		kolomKerjaan.setCellValueFactory(new PropertyValueFactory<>("kerjaan"));
		kolomTanggalMasuk.setCellValueFactory(new PropertyValueFactory<>("now"));
		tableViewServiceHistroy.setItems(WorksHistory);
	}
	public void getCombo(ActionEvent event) throws SQLException, ClassNotFoundException {
		tableViewServiceHistroy.setItems(null);
		WorksHistory.clear();
		if(comboBoxUrutkan.getValue()==null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ED MOTOR","root","");
			sql="select *from `ED MOTOR`.service s  \r\n";
			Statement stmt = con.createStatement();		
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				WorksHistory.add(new Service(rs.getInt("idService"), rs.getString("merkMobil"), rs.getString("VIN"), rs.getString("namaMobil"), rs.getString("jenisMesin"), rs.getInt("ccMesin"), rs.getString("kodeMesin"), rs.getString("jenisKerjaan"),rs.getString("kerjaan"),rs.getString("dateKerjaan")));
			}
			con.close();
		}else if(comboBoxUrutkan.getValue()=="Merk ") {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ED MOTOR","root","");
			sql="select *from `ED MOTOR`.service s  order by merkMobil"; 
			Statement stmt = con.createStatement();		
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				WorksHistory.add(new Service(rs.getInt("idService"), rs.getString("merkMobil"), rs.getString("VIN"), rs.getString("namaMobil"), rs.getString("jenisMesin"), rs.getInt("ccMesin"), rs.getString("kodeMesin"), rs.getString("jenisKerjaan"),rs.getString("kerjaan"),rs.getString("dateKerjaan")));
			}
			con.close();
		}else if(comboBoxUrutkan.getValue()=="Tanggal") {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ED MOTOR","root","");
			sql="select *from `ED MOTOR`.service s  order by dateKerjaan" ;
			Statement stmt = con.createStatement();		
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				WorksHistory.add(new Service(rs.getInt("idService"), rs.getString("merkMobil"), rs.getString("VIN"), rs.getString("namaMobil"), rs.getString("jenisMesin"), rs.getInt("ccMesin"), rs.getString("kodeMesin"), rs.getString("jenisKerjaan"),rs.getString("kerjaan"),rs.getString("dateKerjaan")));
			}
			con.close();
		}else if(comboBoxUrutkan.getValue()=="Jenis Kerjaan") {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ED MOTOR","root","");
			sql="select *from `ED MOTOR`.service s  order by jenisKerjaan \r\n";
			Statement stmt = con.createStatement();		
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				WorksHistory.add(new Service(rs.getInt("idService"), rs.getString("merkMobil"), rs.getString("VIN"), rs.getString("namaMobil"), rs.getString("jenisMesin"), rs.getInt("ccMesin"), rs.getString("kodeMesin"), rs.getString("jenisKerjaan"),rs.getString("kerjaan"),rs.getString("dateKerjaan")));
			}
			con.close();
		}else if(comboBoxUrutkan.getValue()=="Kerjaan") {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ED MOTOR","root","");
			sql="select *from `ED MOTOR`.service s  order by kerjaan \r\n";
			Statement stmt = con.createStatement();		
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				WorksHistory.add(new Service(rs.getInt("idService"), rs.getString("merkMobil"), rs.getString("VIN"), rs.getString("namaMobil"), rs.getString("jenisMesin"), rs.getInt("ccMesin"), rs.getString("kodeMesin"), rs.getString("jenisKerjaan"),rs.getString("kerjaan"),rs.getString("dateKerjaan")));
			}
			con.close();
		}
		kolomIdService.setCellValueFactory(new PropertyValueFactory<>("id"));
		kolomMerkMobil.setCellValueFactory(new PropertyValueFactory<>("Merk"));
		kolomVINMobil.setCellValueFactory(new PropertyValueFactory<>("VIN"));
		kolomNamaMobil.setCellValueFactory(new PropertyValueFactory<>("namaMobil"));
		kolomKodeMesin.setCellValueFactory(new PropertyValueFactory<>("kodeMesin"));
		kolomJenisMesin.setCellValueFactory(new PropertyValueFactory<>("jenisMesin"));
		kolomCCMesin.setCellValueFactory(new PropertyValueFactory<>("ccMesin"));
		kolomJenisKerjaan.setCellValueFactory(new PropertyValueFactory<>("jenisKerjaan"));
		kolomKerjaan.setCellValueFactory(new PropertyValueFactory<>("kerjaan"));
		kolomTanggalMasuk.setCellValueFactory(new PropertyValueFactory<>("now"));
		tableViewServiceHistroy.setItems(WorksHistory);
	}
	public static ObservableList<Service> getHistory() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ED MOTOR","root","");
		sql="select *from `ED MOTOR`.service s  \r\n";
		Statement stmt = con.createStatement();		
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			WorksHistory.add(new Service(rs.getInt("idService"), rs.getString("merkMobil"), rs.getString("VIN"), rs.getString("namaMobil"), rs.getString("jenisMesin"), rs.getInt("ccMesin"), rs.getString("kodeMesin"), rs.getString("jenisKerjaan"),rs.getString("kerjaan"),rs.getString("dateKerjaan")));
		}
		con.close();
		return WorksHistory;
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
    public void homeButton(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}