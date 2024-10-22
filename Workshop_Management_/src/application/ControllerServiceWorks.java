package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ControllerServiceWorks implements Initializable{
	private Stage stage;
    private Scene scene;
    LocalDateTime now = LocalDateTime.now();
    Connection con = null;
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
	private ComboBox<String> jenisKerjaan;
	@FXML
	private ComboBox<String> kerjaan;
	@FXML
	private TextField nominal;

	@FXML
	private Button submit;
	@FXML
    private TableView<Service> tabelDataWorks;
	@FXML
	private TableColumn<Service, String> tabelJenisKerjaan;
	@FXML
	private TableColumn<Service, String> tabelJenisPekerjaan;
    @FXML
    private TableColumn<Service, String> tableTime;
	ObservableList<Service> list = FXCollections.observableArrayList(
			
			);
	private String nullArray;
	private String []Mesin= {"Tune Up","Ganti Oli Mesin","Ganti Oli Set","Ganti Kampas Kopling Set"};
	private String []Chassis= {"Ganti Pintu","Ganti Kaca"};
	private String [] Electrical = {"Service ABS","Service EPS","Service ECM","Wiring Troubleshooting"};
	private String []Wheels= {"Ganti Kampas Rem Set","Ganti ShockAbsorber Set"};
	private String isiJenisKerjaan[]= {"Engine","Chassis","Electrical","Wheels"};
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		jenisKerjaan.getItems().addAll(isiJenisKerjaan);
		tabelJenisKerjaan.setCellValueFactory(new PropertyValueFactory<>("Kerjaan"));
		tabelJenisPekerjaan.setCellValueFactory(new PropertyValueFactory<>("jenisKerjaan"));
		tableTime.setCellValueFactory(new PropertyValueFactory<>("now"));
		tabelDataWorks.setItems(list);
	}	
	public void getWorks(ActionEvent event) {
		Service t = new Service();
		if(kerjaan.getValue()!=null&&jenisKerjaan.getValue()!=null) {
			t.setKerjaan(kerjaan.getValue());
			t.setJenisKerjaan(jenisKerjaan.getValue());
			t.getNow();
			tabelDataWorks.getItems().add(t);
			System.out.println(tabelDataWorks.getItems());
		}
	}
	public void tipeKerjaan() {
		kerjaan.getItems().setAll(nullArray);
		if(jenisKerjaan.getValue().equalsIgnoreCase("Engine"))
			kerjaan.getItems().addAll(Mesin);
		else if(jenisKerjaan.getValue().equalsIgnoreCase("Chassis"))
			kerjaan.getItems().addAll(Chassis);
		else if(jenisKerjaan.getValue().equalsIgnoreCase("Electrical"))
			kerjaan.getItems().addAll(Electrical);
		else if(jenisKerjaan.getValue().equalsIgnoreCase("Wheels"))
			kerjaan.getItems().addAll(Wheels);
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
    public void submitButton(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
    	int idService;
    	for (int j = 0; j < list.size(); j++)
		{
    		idService=Service.cobaReturnIdService();
    		idService++;
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ED MOTOR","root","");
    		String sql = "INSERT INTO `ED MOTOR`.SERVICE \r\n"
    				+ "VALUES\r\n"
    				+ "("+idService+", '"+ControllerServiceDataInPage.getTemp().getServices(0).getMerk()+"', '"+ControllerServiceDataInPage.getTemp().getServices(0).getVIN()+"', '"+ControllerServiceDataInPage.getTemp().getServices(0).getNamaMobil()+"', '"+ControllerServiceDataInPage.getTemp().getServices(0).getJenisMesin()+"', '"+ControllerServiceDataInPage.getTemp().getServices(0).getKodeMesin()+"', "+ControllerServiceDataInPage.getTemp().getServices(0).getCcMesin()+", '"+list.get(j).getJenisKerjaan()+"', '"+list.get(j).getKerjaan()+"', '"+ControllerServiceDataInPage.getTemp().getServices(0).getNow()+"');";
    		Statement stmt = con.createStatement();		
    		stmt = con.createStatement();
    		stmt.executeUpdate(sql);
    		System.out.println("insert service success!");
    	}
    	Parent root = FXMLLoader.load(getClass().getResource("ServiceDataInPage.fxml"));
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