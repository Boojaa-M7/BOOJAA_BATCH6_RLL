package com.example.demo;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class MenuService {
	@Autowired
    private MenuRepository repo;
	 @Autowired
	    private MenuDAO dao;
    
    public List<Menu> showMenu() {
        return repo.findAll();
    }
    
    public Menu get(Integer mid) {
    return repo.findById(mid).get();
   
}
    public String addmenu(Menu menu) {
    	return dao.addmenu(menu);
    }
}
