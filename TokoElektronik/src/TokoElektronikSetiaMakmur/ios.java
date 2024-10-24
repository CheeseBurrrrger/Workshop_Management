package TokoElektronikSetiaMakmur;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ios extends HP{
    private boolean DynamicIsland;
    private boolean AirDrop;
    protected ios(String merk, String prosesor, int stok, int harga, int noImei, boolean tipeCharger, boolean DynamicIsland, boolean AirDrop) throws ClassNotFoundException, SQLException {
		super(merk, prosesor, stok, harga, noImei, tipeCharger);
        this.DynamicIsland = DynamicIsland;
        this.AirDrop = AirDrop;
        String temp=melihatKondisiSql();
		if(temp.equalsIgnoreCase("")) {			
			setIdItem("IOS");
			insertItem();
			insertProduk();
		}
		else return;

        }
        public String isDynamicIsland() {
            if(DynamicIsland){
                return "Tersedia";
            }
            else{
                return "Tidak Tersedia";
            }
        }
        public void setDynamicIsland(boolean dynamicIsland) {
            DynamicIsland = dynamicIsland;
        }
        public String isAirDrop() {
            if(AirDrop){
                return "Tersedia";
            }
            else{
                return "Tidak Tersedia";
            }
        }
        public void setAirDrop(boolean airDrop) {
            AirDrop = airDrop;
        }
//        @Override
//        public void insertProduk() throws ClassNotFoundException, SQLException {
//        	// TODO Auto-generated method stub
//        	super.insertProduk();
//    		String sql = "insert into tokoe.produk values\r\n"
//    				+"('"+getMerk()+"',"+getHarga()+","+getStok()+",'"+getIdItem()+"');\n";
//    		Statement stmt = con.createStatement();		
//    		stmt = con.createStatement();
//    		stmt.executeUpdate(sql);
//    		System.out.println("insert success");
//    		con.close();
//
//
//        }
        public String melihatKondisiSql() throws SQLException, ClassNotFoundException {
    		String sisa="";
    	    Class.forName("com.mysql.cj.jdbc.Driver");
    	    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tokoe", "root", "");
    	    String sql = "select *from tokoe.item i\r\n"
    	    		+ "	where namaitem = 'IOS'";
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
    				+"('IOS','IOS');\n";
    		Statement stmt = con.createStatement();		
    		stmt = con.createStatement();
    		stmt.executeUpdate(sql);
    		System.out.println("insert success");
    		con.close();

        }
        @Override
        public String toString(){
            return  super.toString()+
                    "\nDynamic island\t: "+isDynamicIsland()+
                    "\nAirdrop\t\t: "+isAirDrop();
        }
    }