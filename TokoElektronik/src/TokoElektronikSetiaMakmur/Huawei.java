package TokoElektronikSetiaMakmur;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Huawei extends HP{
    private String EMUIVersion;
    protected Huawei(String merk, String prosesor, int harga, int stok, int noImei, boolean tipeCharger, String EMUIVersion) throws ClassNotFoundException, SQLException {
		super(merk, prosesor, stok, harga, noImei, tipeCharger);
        this.EMUIVersion = EMUIVersion;
        String temp=melihatKondisiSql();
		if(temp.equalsIgnoreCase("")) {			
			setIdItem("HWI");
			insertItem();
			insertProduk();
		}
		else return;

    }
    public String getEMUIVersion() {
        return EMUIVersion;
    }
    public void setEMUIVersion(String eMUIVersion) {
        EMUIVersion = eMUIVersion;
    }
    public String melihatKondisiSql() throws SQLException, ClassNotFoundException {
		String sisa="";
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tokoe", "root", "");
	    String sql = "select *from tokoe.item i\r\n"
	    		+ "	where namaitem = 'HUAWEI'";
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
//    @Override
//    public void insertProduk() throws ClassNotFoundException, SQLException {
//    	// TODO Auto-generated method stub
//    	super.insertProduk();
//		String sql = "insert into tokoe.produk values\r\n"
//				+"('"+getMerk()+"',"+getHarga()+","+getStok()+",'HWI');\n";
//		Statement stmt = con.createStatement();		
//		stmt = con.createStatement();
//		stmt.executeUpdate(sql);
//		System.out.println("insert success");
//		con.close();
//
//
//    }
    @Override
    public void insertItem() throws ClassNotFoundException, SQLException {
    	// TODO Auto-generated method stub
    	super.insertItem();
		String sql = "insert into tokoe.item values\r\n"
				+"('HWI','HUAWEI');\n";
		Statement stmt = con.createStatement();		
		stmt = con.createStatement();
		stmt.executeUpdate(sql);
		System.out.println("insert success");
		con.close();

    }
    
    public String toString(){
		return  super.toString()+ "\nEMUI Version\t: "+getEMUIVersion();
	}
}