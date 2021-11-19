package com.example.demo;
import java.sql.ResultSet;
import java.util.List;
import java.security.interfaces.RSAKey;

import java.sql.SQLException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class MenuDAO {
	 @Autowired  
	    JdbcTemplate jdbc; 
	 public int generateId()
		{
			String cmd="select max(mid) from menu";
			List li=jdbc.query(cmd , new RowMapper() {

				@Override
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						return rs.getInt(1)+1;
				}
				
			});
			return (int) li.get(0);
		}
	 public String addmenu(Menu menu) {
	    	int id=generateId();
	    	String cmd = "insert into menu(mid,mitem,mprice,mcalories,mspeciality) values(?,?,?,?,?)";
	    	 jdbc.update(cmd,id,menu.getMitem(),menu.getMprice(),
	    			 menu.getMcalories(), 
	    			 menu.getMspeciality());
	    	 return "record inserted";
	    	
	    }
	    public Menu searchmenu(int mid) {
	        String cmd = "select * from menu where mid=?";
	        List<Menu> menuList=jdbc.query(cmd,new Object[] {mid}, new RowMapper<Menu>() {
	            @Override
	            public Menu mapRow(ResultSet rs, int arg1) throws SQLException {
	                Menu menu = new Menu();
	                menu.setMid(rs.getInt("mid"));
	                menu.setMitem(rs.getString("mitem"));
	                menu.setMprice(rs.getDouble("mprice"));
	                menu.setMcalories(rs.getInt("mcalories"));
	                menu.setMspeciality(rs.getString("mspeciality"));
	                return menu;
	            }
	            
	        });
	        return menuList.get(0);
	    }
}
