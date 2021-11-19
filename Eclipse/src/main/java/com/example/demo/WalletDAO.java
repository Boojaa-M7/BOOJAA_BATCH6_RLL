package com.example.demo;
import java.security.interfaces.RSAKey;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
@Repository	
public class WalletDAO {
	@Autowired  
    JdbcTemplate jdbc;  
	
	public int generateId()
	{
		String cmd="select max(WAL_ID) from Wallet";
		List li=jdbc.query(cmd,  new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs,int  rowNum) throws SQLException {
				return rs.getInt(1)+1;
			}
		});
		return (int) li.get(0);
	}
	public String refundWallet(int CUS_ID, String WAL_SOURCE, double WAL_AMOUNT) {
		String cmd = "Update Wallet set WAL_AMOUNT=WAL_AMOUNT+? "
				+ " WHERE CUS_ID=? AND WAL_SOURCE=?";
		jdbc.update(cmd, new Object[] {WAL_AMOUNT,CUS_ID,WAL_SOURCE});
		return "Amount Debited from Wallet...";
	}
	public String addwallet(Wallet wal) {
    	int id=generateId();
    	String cmd = "insert into Wallet(CUS_ID,WAL_ID,WAL_AMOUNT,WAL_SOURCE) values(?,?,?,?)";
    	 jdbc.update(cmd,wal.getCUS_ID(),id,wal.getWAL_AMOUNT(),
    			 wal.getWAL_SOURCE());
    	 SendEmail.sendemail1();
    	 return "Account created Succesfully";
    	
    }
	public List<Wallet> showwallet(int CUS_ID) {
		String cmd = "select * from Wallet where CUS_ID=? ";
		List<Wallet> walletList=null;
		walletList=jdbc.query(cmd,new Object[] {CUS_ID}, new RowMapper<Wallet>() {

			@Override
            public Wallet mapRow(ResultSet rs, int rowNum) throws SQLException {
                // TODO Auto-generated method stub
            	
            	Wallet od = new Wallet();
        			od.setCUS_ID(rs.getInt("CUS_ID"));
        			od.setWAL_ID(rs.getInt("WAL_ID"));
        			od.setWAL_AMOUNT(rs.getInt("WAL_AMOUNT"));
        			od.setWAL_SOURCE(rs.getString("WAL_SOURCE"));
    
        		return od;
            }
			
		});
		return walletList;
	}
	public String updateWallet(int CUS_ID, String WAL_SOURCE, double WAL_AMOUNT) {
        String cmd = "Update Wallet set WAL_AMOUNT=WAL_AMOUNT-? "
                + " WHERE CUS_ID=? AND WAL_SOURCE=?";
        jdbc.update(cmd, new Object[] {WAL_AMOUNT,CUS_ID,WAL_SOURCE});
        return "Amount Debited from Wallet...";
    }
	public Wallet showwallets(int CUS_ID,String WAL_SOURCE) {
		String cmd = "select * from Wallet where CUS_ID=? AND WAL_SOURCE=?";
		List<Wallet> walletList=null;
		walletList=jdbc.query(cmd,new Object[] {CUS_ID,WAL_SOURCE}, new RowMapper<Wallet>() {
			@Override
            public Wallet mapRow(ResultSet rs, int rowNum) throws SQLException {
                // TODO Auto-generated method stub
            	Wallet od = new Wallet();
        			od.setCUS_ID(rs.getInt("CUS_ID"));
        			od.setWAL_ID(rs.getInt("WAL_ID"));
        			od.setWAL_AMOUNT(rs.getInt("WAL_AMOUNT"));
        			od.setWAL_SOURCE(rs.getString("WAL_SOURCE"));
    
        		return od;
            }
			
		});
		return walletList.get(0);
	}
}
