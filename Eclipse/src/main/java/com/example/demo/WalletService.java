package com.example.demo;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
@Service
@Transactional
public class WalletService {
	@Autowired
    private WalletRepository repo;
	@Autowired
    private WalletDAO dao;
	public List<Wallet> showwallet(int CUS_ID) {
		// TODO Auto-generated method stub
		return dao.showwallet(CUS_ID);
	}
	public Wallet showwallets(int CUS_ID,String WAL_SOURCE) {
		// TODO Auto-generated method stub
		 return dao.showwallets(CUS_ID,WAL_SOURCE);
		
	}
	public String addwallet(Wallet wal) {
    	return dao.addwallet(wal);
    }
}
