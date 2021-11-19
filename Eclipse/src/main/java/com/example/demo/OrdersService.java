package com.example.demo;
import javax.transaction.Transactional;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
@Service
@Transactional
public class OrdersService {
	@Autowired
    private OrdersRepository repo;
	@Autowired
    private OrdersDAO dao;
    
	 @Autowired 
	    private MenuDAO mdao;
	 @Autowired 
	    private WalletDAO wdao;
	 @Autowired
		private OrdersDAO odao;
		
	 
	 public String placeOrder(Orders order) {
	        Menu menu = mdao.searchmenu(order.getOmid());
	        Wallet wallet = wdao.showwallets(order.getOcid(), order.getWal_source());
	        double balance = wallet.getWAL_AMOUNT();
	        double billAmount = order.getOrd_quantity()*menu.getMprice();
	        int bill = (int) billAmount;
	        System.out.println(balance);
	        System.out.println(billAmount);
	        if (balance-bill > 0) {
	        	order.setOid(dao.generateId());
	            order.setOrd_status("PENDING");
	            order.setOrd_billamount(bill);
	            repo.save(order);
	            SendEmail.sendemail();
	            wdao.updateWallet(order.getOcid(), order.getWal_source(), bill);
	            return "Order Placed Successfully...and Amount Debited";
	        }
	        return "Insufficient Funds...";
	    }
	    public String acceptOrRejectOrder(int oid,int ovid,String ord_status) {
			Orders orders = dao.searchByOrderId(oid);
			int vid = orders.getOvid();
			int cid = orders.getOcid();
			String walType = orders.getWal_source();
			double billAmount = orders.getOrd_billamount();
			if (vid!=ovid) {
				return "You are unauthorized vendor...";
			} 
			if (ord_status.toUpperCase().equals("YES")) {
				return dao.updateStatus(oid,"ACCEPTED");
			} else {
				dao.updateStatus(oid, "DENIED");
				wdao.refundWallet(cid, walType, billAmount);
				return "Order Rejected and Amount Refunded...";
			}
		}
    
    public List<Orders> showOrders() {
        return repo.findAll();
    }
    public List<Orders> vsorders(int ovid) {
		// TODO Auto-generated method stub
		return dao.vsorders(ovid);
	}
    public List<Orders> vporders(int ovid) {
		// TODO Auto-generated method stub
		return dao.vporders(ovid);
	}
    
    public List<Orders> sorders(int ocid) {
		// TODO Auto-generated method stub
		return dao.sorders(ocid);
	}
    public List<Orders> porders(int ocid) {
		// TODO Auto-generated method stub
		return dao.porders(ocid);
	}
    public int generateId()
    {
    	return dao.generateId();
    }
}
