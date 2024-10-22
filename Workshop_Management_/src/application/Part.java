package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Part {
	private String namaPart,merkPart,tipePart;
	private char jenisPart;
	private int partNumber, harga,stok;
	private int idPart=0;
	static Connection con=null;
	public String getTipePart() {
		return tipePart;
	}

	public void setTipePart(String tipePart) {
		this.tipePart = tipePart;
	}
	public static int cobaReturnIdPart() throws ClassNotFoundException, SQLException {
		int data=0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ED MOTOR","root","");
		String sql = "select idPart\r\n"
				+ "from `ED MOTOR`.part p ";
		Statement stmt = con.createStatement();
	    stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(sql);
	    while(rs.next()) {
	    	data=rs.getInt("idPart");
	    }
	    con.close();
	    return data;
	}
	public Part(String merkPart,String namaPart,String tipePart, char jenisPart, int partNumber, int harga, int stok) throws ClassNotFoundException, SQLException {
		setNamaPart(namaPart);
		setMerkPart(merkPart);
		setTipePart(tipePart);
		setJenisPart(jenisPart);
		setPartNumber(partNumber);
		setHarga(harga);
		setStok(stok);
	}

	public int getStok() {
		return stok;
	}

	public void setStok(int stok) {
		this.stok += stok;
	}

	public String getMerkPart() {
		return merkPart;
	}

	public void setMerkPart(String merkPart) {
		this.merkPart = merkPart;
	}

	public String getNamaPart() {
		return namaPart;
	}

	public void setNamaPart(String namaPart) {
		this.namaPart = namaPart;
	}

	public char getJenisPart() {
		return jenisPart;
	}

	public void setJenisPart(char jenisPart) {
		this.jenisPart = jenisPart;
	}

	public int getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(int partNumber) {
		this.partNumber = partNumber;
	}

	public int getHarga() {
		return harga;
	}

	public void setHarga(int harga) {
		this.harga = harga;
	}
	@Override
	public String toString() {
		return  
				"\nMerk part\t: "+getMerkPart()+
				"\nNama part\t: "+getNamaPart()+
				"\nTipe part\t: "+getTipePart()+
				"\nJenis part\t: "+getJenisPart()+
				"\nPart number\t: "+getPartNumber()+
				"\nHarga\t\t: Rp"+getHarga()+
				"\nSisa Stok\t: "+getStok();
	}	
}