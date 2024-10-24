package TokoElektronikSetiaMakmur;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Windows extends Laptop{
    private boolean VGADiskrit;
    protected Windows(String merk, String prosesor, int stok, int harga, boolean tipeLayar, boolean VGADiskrit) throws ClassNotFoundException, SQLException{    
        super(merk, prosesor, stok, harga, tipeLayar);
        this.VGADiskrit =VGADiskrit;
        String temp=melihatKondisiSql();

		if(temp.equalsIgnoreCase("")) {			
			setIdItem("WIN");
			insertItem();
			insertProduk();
		}
		else return;

    }
    public String isVGADiskrit() {
        if(VGADiskrit==true){
            return "Dedicated";
        }
        else{
            return "Integrated";
        }
    }
    public void setVGADiskrit(boolean vGADiskrit) {
        VGADiskrit = vGADiskrit;
    }
//    @Override
//    public void insertProduk() throws ClassNotFoundException, SQLException {
//    	// TODO Auto-generated method stub
//    	super.insertProduk();
//		String sql = "insert into tokoe.produk values\r\n"
//				+"('"+getMerk()+"',"+getHarga()+","+getStok()+",'WIN');\n";
//		Statement stmt = con.createStatement();		
//		stmt = con.createStatement();
//		stmt.executeUpdate(sql);
//		System.out.println("insert success");
//		con.close();
//
//    }
    public String melihatKondisiSql() throws SQLException, ClassNotFoundException {
		String sisa="";
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tokoe", "root", "");
	    String sql = "select *from tokoe.item i\r\n"
	    		+ "	where namaitem = 'WINDOWS'";
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
    public void insertItem() throws ClassNotFoundException, SQLException {
    	// TODO Auto-generated method stub
    	super.insertItem();
		String sql = "insert into tokoe.item values\r\n"
				+"('WIN','WINDOWS');\n";
		Statement stmt = con.createStatement();		
		stmt = con.createStatement();
		stmt.executeUpdate(sql);
		System.out.println("insert success");
		con.close();

    }
    public String toString(){
    return  super.toString()+
            "\nVGA\t\t: "+isVGADiskrit();
    }
}