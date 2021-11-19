package com.example.demo;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class CustomerController {
	@Autowired
    private CustomerService service1;
	@Autowired
	private VendorService service;
	@Autowired
    private MenuService service2;
	@Autowired
    private OrdersService serviceo;
	@Autowired
    private WalletService servicew;
	
	
   @RequestMapping(value="/")
   public String sayHello() {
       return "welcome";
   }
   @RequestMapping("/customerAuthenticate/{user}/{pwd}")
   public String autneticateion1(@PathVariable String user, @PathVariable String pwd) {
       return service1.authenticate(user, pwd);
   }
   @RequestMapping("/customerAuthen/{user}")
   public customer authen(@PathVariable String user) {
       return service1.authen(user);
   }
	 @RequestMapping(value="/showcustomer")
	    public List<customer> list() {
	        return service1.showCustomer();
	    }
	 
	 @GetMapping("/customer/{id}")
	    public ResponseEntity<customer> get1(@PathVariable int id) {
	        try {
	            customer cus = service1.get(id);
	            return new ResponseEntity<customer>(cus, HttpStatus.OK);
	        } catch (NoSuchElementException e) {
	            return new ResponseEntity<customer>(HttpStatus.NOT_FOUND);
	        }      
	    }
	    @PostMapping("/addcustomer")
	    public String addcustomer(@RequestBody customer cus) {
	       return service1.addcustomer(cus);
	    }
			
			@RequestMapping("/vendorAuthenticate/{user}/{pwd}")
		    public String autneticateion(@PathVariable String user, @PathVariable String pwd) {
		        return service.authenticate(user, pwd);
		    }
			@RequestMapping("/vendorAuthenv/{user}")
			   public Vendor authenv(@PathVariable String user) {
			       return service.authen1(user);
			   }
		 
		 @RequestMapping(value="/showvendors")
		    public List<Vendor> list1() {
		        return service.showVendor();
		    }
		 
		 @GetMapping("/vendors/{id}")
		    public ResponseEntity<Vendor> get(@PathVariable Integer id) {
		        try {
		            Vendor ven = service.get(id);
		            return new ResponseEntity<Vendor>(ven, HttpStatus.OK);
		        } catch (NoSuchElementException e) {
		            return new ResponseEntity<Vendor>(HttpStatus.NOT_FOUND);
		        }      
		    }
		 @PostMapping("/addvendor")
		    public String addvendor(@RequestBody Vendor ven) {
		        return service.addvendor(ven);
		    }
			 @RequestMapping(value="/showmenus")
			    public List<Menu> list11() {
			        return service2.showMenu();
			    }
			 
			 @GetMapping("/menus/{mid}")
			    public ResponseEntity<Menu> get11(@PathVariable Integer mid) {
			        try {
			            Menu menu = service2.get(mid);
			            return new ResponseEntity<Menu>(menu, HttpStatus.OK);
			        } catch (NoSuchElementException e) {
			            return new ResponseEntity<Menu>(HttpStatus.NOT_FOUND);
			        }      
			    }
			 @PostMapping("/addmenu")
			    public String addmenu(@RequestBody Menu menu) {
			       return service2.addmenu(menu);
			    }
			 @RequestMapping(value="/showorders")
			    public List<Orders> listo() {
			        return serviceo.showOrders();
			    }
			 @RequestMapping(value="/sorders/{ocid}")
				public List<Orders> sorders(@PathVariable int ocid) {
					return serviceo.sorders(ocid);
				}
			 @RequestMapping(value="/porders/{ocid}")
				public List<Orders> porders(@PathVariable int ocid) {
					return serviceo.porders(ocid);
				}
			 @RequestMapping(value="/vsorders/{ovid}")
				public List<Orders> vsorders(@PathVariable int ovid) {
					return serviceo.vsorders(ovid);
				}
			 @RequestMapping(value="/vporders/{ovid}")
				public List<Orders> vporders(@PathVariable int ovid) {
					return serviceo.vporders(ovid);
				}
			 @RequestMapping(value="/showwallet/{CUS_ID}")
				public List<Wallet>showwallet(@PathVariable int CUS_ID) {
					return servicew.showwallet(CUS_ID);
				}
			 @RequestMapping(value="/showwallets/{CUS_ID}/{WAL_SOURCE}")
				public Wallet showwallets(@PathVariable int CUS_ID,@PathVariable String WAL_SOURCE) {
					return servicew.showwallets(CUS_ID,WAL_SOURCE);
				}
			 @PostMapping("/addwallet")
			    public String addwallet(@RequestBody Wallet wal) {
			       return servicew.addwallet(wal);
			    }
			 @PostMapping("/placeOrder")
			    public String add(@RequestBody Orders orders) {
			        return serviceo.placeOrder(orders);
			    }
			 @RequestMapping(value="/generateId")
			    public int generateId() {
			        return serviceo.generateId();
			    }
			 @PostMapping("/acceptOrRejectOrder/{oid}/{ovid}/{ord_status}")
				public String acceptOrReject(@PathVariable int oid,@PathVariable int ovid, 
						@PathVariable String ord_status) {
					return serviceo.acceptOrRejectOrder(oid,ovid,ord_status);
				}

	 
}
