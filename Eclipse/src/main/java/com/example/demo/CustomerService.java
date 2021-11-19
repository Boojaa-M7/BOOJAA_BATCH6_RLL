package com.example.demo;
import javax.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
@Service
@Transactional
public class CustomerService {
	@Autowired
    private CustomerrRepository repo;
	@Autowired
    private CustomerDAO dao;
    
	 public String authenticate(String user,String pwd) {
	        return dao.authenticate(user, pwd);
	    }
	    public customer authen(String user) {
	        return dao.authen(user);
	    }
	    public List<customer> showCustomer() {
	        return repo.findAll();
	    }
	    
	    public customer get(Integer id) {
	        return repo.findById(id).get();   
	    }
	    public String addcustomer(customer cus) {
	    	return dao.addcustomer(cus);
	    	
	    }}
