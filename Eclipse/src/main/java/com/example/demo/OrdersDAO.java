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
public class OrdersDAO {
	@Autowired  
    JdbcTemplate jdbc; 
	public int generateId()
	{
		String cmd="select max(oid) from orders";
		List li=jdbc.query(cmd,  new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs,int  rowNum) throws SQLException {
				return rs.getInt(1)+1;
			}
		});
		return (int) li.get(0);
	}
	public Orders searchByOrderId(int oid) {
        String cmd = "select * from orders where oid=?";
        List<Orders> ordersList=null;
        ordersList=jdbc.query(cmd,new Object[] {oid}, new RowMapper<Orders>() {
            @Override
            public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
            	Orders od = new Orders();
    			od.setOid(rs.getInt("oid"));
    			od.setOcid(rs.getInt("ocid"));
    			od.setOvid(rs.getInt("ovid"));
    			od.setWal_source(rs.getString("wal_source"));
    			od.setOmid(rs.getInt("omid"));
    			od.setOrd_date(rs.getDate("ord_date"));
    			od.setOrd_quantity(rs.getInt("ord_quantity"));
    			od.setOrd_billamount(rs.getInt("ord_billamount"));
    			od.setOrd_status(rs.getString("ord_status"));
    			od.setOrd_comments(rs.getString("ord_comments"));

    		return od;
            } 
        });
        return ordersList.get(0);
    }
	public String updateStatus(int ordId,String ordStatus) {
		String cmd = "Update orders set ord_status=? WHERE oid=?";
		jdbc.update(cmd, new Object[] {ordStatus,ordId});
		return "Order Accepted...";
	}
	public List<Orders> sorders(int ocid) {
		String cmd = "select * from orders where ocid=? ";
		List<Orders> ordersList=null;
		ordersList=jdbc.query(cmd,new Object[] {ocid}, new RowMapper<Orders>() {

			@Override
            public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
                // TODO Auto-generated method stub
            	
            	Orders od = new Orders();
        			od.setOid(rs.getInt("oid"));
        			od.setOcid(rs.getInt("ocid"));
        			od.setOvid(rs.getInt("ovid"));
        			od.setWal_source(rs.getString("wal_source"));
        			od.setOmid(rs.getInt("omid"));
        			od.setOrd_date(rs.getDate("ord_date"));
        			od.setOrd_quantity(rs.getInt("ord_quantity"));
        			od.setOrd_billamount(rs.getInt("ord_billamount"));
        			od.setOrd_status(rs.getString("ord_status"));
        			od.setOrd_comments(rs.getString("ord_comments"));
    
        		return od;
            }
			
		});
		return ordersList;
	}
	public List<Orders> porders(int ocid) {
		String cmd = "select * from orders where ord_status='PENDING' " + " AND ocid=? ";
		List<Orders> ordersList=null;
		ordersList=jdbc.query(cmd,new Object[] {ocid}, new RowMapper<Orders>() {

            @Override
            public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
                // TODO Auto-generated method stub
            	
            	Orders od = new Orders();
        			od.setOid(rs.getInt("oid"));
        			od.setOcid(rs.getInt("ocid"));
        			od.setOvid(rs.getInt("ovid"));
        			od.setWal_source(rs.getString("wal_source"));
        			od.setOmid(rs.getInt("omid"));
        			od.setOrd_date(rs.getDate("ord_date"));
        			od.setOrd_quantity(rs.getInt("ord_quantity"));
        			od.setOrd_billamount(rs.getInt("ord_billamount"));
        			od.setOrd_status(rs.getString("ord_status"));
        			od.setOrd_comments(rs.getString("ord_comments"));
    
        		return od;
            }
            
        });
        return ordersList;
	}
	public List<Orders> vsorders(int ovid) {
		String cmd = "select * from orders where ovid=? ";
		List<Orders> ordersList=null;
		ordersList=jdbc.query(cmd,new Object[] {ovid}, new RowMapper<Orders>() {
            @Override
            public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
                // TODO Auto-generated method stub
            	
            	Orders od = new Orders();
        			od.setOid(rs.getInt("oid"));
        			od.setOcid(rs.getInt("ocid"));
        			od.setOvid(rs.getInt("ovid"));
        			od.setWal_source(rs.getString("wal_source"));
        			od.setOmid(rs.getInt("omid"));
        			od.setOrd_date(rs.getDate("ord_date"));
        			od.setOrd_quantity(rs.getInt("ord_quantity"));
        			od.setOrd_billamount(rs.getInt("ord_billamount"));
        			od.setOrd_status(rs.getString("ord_status"));
        			od.setOrd_comments(rs.getString("ord_comments"));
    
        		return od;
            }
            
        });
        return ordersList;
	}
	public List<Orders> vporders(int ovid) {
		String cmd = "select * from orders where ord_status='PENDING' " + " AND ovid=? ";
		List<Orders> ordersList=null;
		ordersList=jdbc.query(cmd,new Object[] {ovid}, new RowMapper<Orders>() {
            @Override
            public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
                // TODO Auto-generated method stub
            	
            	Orders od = new Orders();
        			od.setOid(rs.getInt("oid"));
        			od.setOcid(rs.getInt("ocid"));
        			od.setOvid(rs.getInt("ovid"));
        			od.setWal_source(rs.getString("wal_source"));
        			od.setOmid(rs.getInt("omid"));
        			od.setOrd_date(rs.getDate("ord_date"));
        			od.setOrd_quantity(rs.getInt("ord_quantity"));
        			od.setOrd_billamount(rs.getInt("ord_billamount"));
        			od.setOrd_status(rs.getString("ord_status"));
        			od.setOrd_comments(rs.getString("ord_comments"));
    
        		return od;
            }
            
        });
        return ordersList;
	}
}
