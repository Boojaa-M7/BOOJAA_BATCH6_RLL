package com.example.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class VendorService {
	@Autowired
    private VendorRepository repo;
	@Autowired
    private VendorDAO dao;
    
    public String authenticate(String user,String pwd) {
        return dao.authenticate(user, pwd);
    }
    public Vendor authen1(String user) {
        return dao.authen1(user);
    }
    public List<Vendor> showVendor() {
        return repo.findAll();
    }
    public Vendor get(Integer id) {
        return repo.findById(id).get();
       
    }
    public String addvendor(Vendor ven) {
    	return dao.addvendor(ven);
    }
}
