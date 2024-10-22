package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Service {
	private String Merk, VIN,namaMobil, kodeMesin;
	private String jenisMesin;
	private int ccMesin,id;
	private String jenisKerjaan;
	private String kerjaan;
	String now=LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY/MM/dd hh:mm"));
	static Connection con=null;
	public String getNow() {
		return now;
	}
	public void setNow(String now) {
		this.now = now;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Service() {
		
	}
	public String getJenisKerjaan() {
		return jenisKerjaan;
	}
	public void setJenisKerjaan(String jenisKerjaan) {
		this.jenisKerjaan = jenisKerjaan;
	}
	public String getKerjaan() {
		return kerjaan;
	}
	public void setKerjaan(String kerjaan) {
		this.kerjaan = kerjaan;
	}
	public Service(String jenisKerjaan,String kerjaan) {
		this.jenisKerjaan=jenisKerjaan;
		this.kerjaan=kerjaan;
	}
	public Service(String Merk, String VIN, String namaMobil, String isMesin,int ccMesin,String kodeMesin) {
		setMerk(Merk);
		setVIN(VIN);
		setNamaMobil(namaMobil);
		setMesin(isMesin);
		setKodeMesin(kodeMesin);
	}
	public Service (int id,String Merk, String VIN, String namaMobil, String isMesin,int ccMesin,String kodeMesin,String jenisKerjaan,String kerjaan) {
		setMerk(Merk);
		setVIN(VIN);
		setNamaMobil(namaMobil);
		setMesin(isMesin);
		setKodeMesin(kodeMesin);
		setCcMesin(ccMesin);
		this.jenisKerjaan=jenisKerjaan;
		this.kerjaan=kerjaan;
		this.id=id;
	}
	public Service (int id,String Merk, String VIN, String namaMobil, String isMesin,int ccMesin,String kodeMesin,String jenisKerjaan,String kerjaan,String date) {
		setMerk(Merk);
		setVIN(VIN);
		setNamaMobil(namaMobil);
		setMesin(isMesin);
		setKodeMesin(kodeMesin);
		setCcMesin(ccMesin);
		this.jenisKerjaan=jenisKerjaan;
		this.kerjaan=kerjaan;
		this.id=id;
		now=date;
	}

	public String getMerk() {
		return Merk;
	}

	public void setMerk(String merk) {
		Merk = merk;
	}

	public String getVIN() {
		return VIN;
	}

	public void setVIN(String vIN) {
		VIN = vIN;
	}

	public String getNamaMobil() {
		return namaMobil;
	}

	public void setNamaMobil(String namaMobil) {
		this.namaMobil = namaMobil;
	}

	public String getKodeMesin() {
		return kodeMesin;
	}

	public void setKodeMesin(String kodeMesin) {
		this.kodeMesin = kodeMesin;
	}

	public String getJenisMesin() {
		return jenisMesin;
	}

	public void setMesin(String jenisMesin) {
		this.jenisMesin = jenisMesin;
	}

	public int getCcMesin() {
		return ccMesin;
	}

	public void setCcMesin(int ccMesin) {
		this.ccMesin = ccMesin;
	}
	public static int cobaReturnIdService() throws ClassNotFoundException, SQLException {
		int data=0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ED MOTOR","root","");
		String sql = "select idService\r\n"
				+ "from `ED MOTOR`.service s";
		Statement stmt = con.createStatement();
	    stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(sql);
	    while(rs.next()) {
	    	data=rs.getInt("idService");
	    }
	    con.close();
	    return data;
	}
	@Override
	public String toString() {
		return "\nMerk:"+getMerk()+
				"\nVIN: "+getVIN()+
				"\nNama Mobil: "+getNamaMobil()+
				"\nJenis Mesin: "+getJenisMesin()+
				"\nKode Mesin: "+getKodeMesin()+
				"\nCC mesin: "+getCcMesin()+
				"\nJenis kerjaan: "+getJenisKerjaan()+
				"\nKerjaan: "+getKerjaan()+
				"\nTime: "+getNow();		
	}
}