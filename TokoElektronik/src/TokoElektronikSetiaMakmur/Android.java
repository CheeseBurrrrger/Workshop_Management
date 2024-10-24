package TokoElektronikSetiaMakmur;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Android extends HP{
	private String androidVersion;
	protected Android(String merk, String prosesor, int stok, int harga, int noImei, boolean tipeCharger, String androidVersion) throws ClassNotFoundException, SQLException {
		super(merk, prosesor, stok, harga, noImei, tipeCharger);
		this.androidVersion=androidVersion;
		String temp=melihatKondisiSql();
		if(temp.equalsIgnoreCase("")) {
			setIdItem("AND");
			insertItem();
			insertProduk();
		}
		else return;
		
		
	}
	public String melihatKondisiSql() throws SQLException, ClassNotFoundException {
		String sisa="";
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tokoe", "root", "");
	    String sql = "select *from tokoe.item i\r\n"
	    		+ "	where namaitem = 'ANDROID'";
	    Statement stmt = con.createStatement();
	    stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(sql);
	    while(rs.next()) {
	    	sisa=rs.getString("id_item");
	    	setIdItem(sisa);
	    	return sisa;
	    }
	    con.close();
	    return sisa;
}
	@Override
	public void memperbaruiStok() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		super.memperbaruiStok();
		String sql = "update tokoe.produk \r\n"
				+ "		set STOK_ITEM ="+getStok()+"\r\n"
				+ "		where MERK ='"+getMerk()+"';";
		Statement stmt = con.createStatement();		
		stmt = con.createStatement();
		stmt.executeUpdate(sql);
		System.out.println("update success");
		con.close();

		
	}
	public String getAndroidVersion() {
		return androidVersion;
	}
	public void setAndroidVersion(String androidVersion) {
		this.androidVersion = androidVersion;
	}
//	@Override
//	public void insertProduk() throws ClassNotFoundException, SQLException {
//		// TODO Auto-generated method stub
//		super.insertProduk();
//		String sql = "insert into tokoe.produk values\r\n"
//				+"('"+getMerk()+"',"+getHarga()+","+getStok()+",'AND');\n";
//		Statement stmt = con.createStatement();		
//		stmt = con.createStatement();
//		stmt.executeUpdate(sql);
//		System.out.println("insert success");
//		con.close();
//
//	}
	@Override
	public void transaksiSql() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		super.transaksiSql();
		 String sql = "insert into tokoe.transaksi values\r\n"
					+"('"+getUniqueIDLanjutan()+"','"+getCurrentDateTime()+"',"+getKuantitas()+","+getHarga()+",'"+getIdItem()+"','"+getMerk()+"',"+duitToko()+");\n";
			Statement stmt = con.createStatement();		
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("transaction success");
			con.close();

		 
	}
	@Override
	public void insertItem() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		super.insertItem();
		String sql = "insert into tokoe.item values\r\n"
				+"('"+getIdItem()+"','ANDROID');\n";
		Statement stmt = con.createStatement();		
		stmt = con.createStatement();
		stmt.executeUpdate(sql);
		System.out.println("insert success");
		con.close();
//		String sql = "insert into tokoe.item values\r\n"
//				+"('AND','ANDROID',"+getStok()+"),\n"+
//				"('IOS','IOS',"+getStok()+"),\n"+
//				"('HWI','HUAWEI',"+getStok()+"),\n"+
//				"('WIN','WINDOWS',"+getStok()+"),\n"+
//				"('MAC','MACBOOK',"+getStok()+")\n";
//		Statement stmt = con.createStatement();		
//		stmt = con.createStatement();
//		stmt.executeUpdate(sql);
//		System.out.println("insert success");

	}
	
	@Override
	public String toString(){
		return  super.toString()+
				"\nVersi Android\t: "+androidVersion;		
	}
}
