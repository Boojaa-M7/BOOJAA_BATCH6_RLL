package com.example.demo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class VendorDAO {
	@Autowired  
    JdbcTemplate jdbc;  
	public int generateId()
	{
		String cmd="select max(vid) from vendor";
		List li=jdbc.query(cmd , new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					return rs.getInt(1)+1;
			}
			
		});
		return (int) li.get(0);
	}
	public String addvendor(Vendor ven) {
    	int id=generateId();
    	String cmd = "insert into vendor(vid,vname,vphno,vusername,vpassword,vemail) values(?,?,?,?,?,?)";
    	 jdbc.update(cmd,id,ven.getVname(),ven.getVphno(),
    			 ven.getVusername(), 
    			 ven.getVpassword(),ven.getVemail());
    	 return "record inserted";
    	
    }
    public String authenticate(String user,String pwd) {
        String cmd = "select count(*) cnt from vendor where vusername=? "
                + " AND vpassword=?";
        List str=jdbc.query(cmd,new Object[] {user,pwd}, new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                // TODO Auto-generated method stub
                return rs.getInt("cnt");
            }
            
        });
        return str.get(0).toString();
    }
    public Vendor authen1(String user)
    {
    	String cmd = "select * from vendor where vusername=? ";
    
    	List<Vendor> str = jdbc.query(cmd,new Object[] {user},new RowMapper(){
    		@Override
    		public Object mapRow(ResultSet rs,int rowNum) throws SQLException{
    			Vendor c =new Vendor();
    			c.setVid(rs.getInt("vid"));
    			c.setVname(rs.getString("vname"));
    			c.setVphno(rs.getString("vphno"));
    			c.setVusername(rs.getString("vusername"));
    			c.setVpassword(rs.getString("vpassword"));
    			c.setVemail(rs.getString("vemail"));
    			return c;
    		}
    	});
    	return str.get(0);
    }
}
