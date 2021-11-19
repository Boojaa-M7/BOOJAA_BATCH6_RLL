package com.example.demo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
@Repository
public class CustomerDAO {
	@Autowired  
    JdbcTemplate jdbc;  
	public int generateId()
	{
		String cmd="select max(CUS_ID) from customer";
		List li=jdbc.query(cmd , new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					return rs.getInt(1)+1;
			}
			
		});
		return (int) li.get(0);
	}
    public String authenticate(String user,String pwd) {
        String cmd = "select count(*) cnt from customer where CUS_USERNAME=? "
                + " AND CUS_PASSWORD=?";
        List str=jdbc.query(cmd,new Object[] {user,pwd}, new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                // TODO Auto-generated method stub
                return rs.getInt("cnt");
            }
            
        });
        return str.get(0).toString();
    }
    public customer authen(String user) {
		String cmd = "select * from customer where CUS_USERNAME=? ";
        List<customer> str=jdbc.query(cmd,new Object[] {user}, new RowMapper<customer>() {
            @Override
            public customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                // TODO Auto-generated method stub
            	customer c=new customer();
				c.setCUS_ID(rs.getInt("CUS_ID"));
				c.setCUS_NAME(rs.getString("CUS_NAME"));
				c.setCUS_PHN_NO(rs.getString("CUS_PHN_NO"));
				c.setCUS_USERNAME(rs.getString("CUS_USERNAME"));
				c.setCUS_PASSWORD(rs.getString("CUS_PASSWORD"));
				c.setCUS_EMAIL(rs.getString("CUS_EMAIL"));
				return c;
            }
            
        });
        return str.get(0);
    }
    public String addcustomer(customer cus) {
    	int id=generateId();
    	String cmd = "insert into customer(CUS_ID,CUS_NAME,CUS_PHN_NO,CUS_USERNAME,CUS_PASSWORD,CUS_EMAIL) values(?,?,?,?,?,?)";
    	 jdbc.update(cmd,id,cus.getCUS_NAME(),cus.getCUS_PHN_NO(),
    			 cus.getCUS_USERNAME(), 
    			 cus.getCUS_PASSWORD(),cus.getCUS_EMAIL());
    	 SendEmail.sendemail1();
    	 return "Account created Succesfully";
    	
    }
}
