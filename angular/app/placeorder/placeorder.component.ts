import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Observable } from 'rxjs';
import { Customer } from '../customer';
import { Menu } from '../menu';
import { Orders } from '../orders';
import { MenuService } from '../menu.service';
import { Vendors } from '../vendors';
import { Wallet } from '../wallet';
import { VendorsService } from '../vendors.service';
import { WalletService } from '../wallet.service';
import { OrdersService } from '../orders.service';
@Component({
  selector: 'app-placeorder',
  templateUrl: './placeorder.component.html',
  styleUrls: ['./placeorder.component.css']
})
export class PlaceorderComponent implements OnInit {
cus: Customer;
orderdetails:Orders;
menufound:Menu;
menu:Observable<Menu[]>;
price:number;
msg: string;
vendor:Observable<Vendors[]>
wallet:Observable<Wallet[]>
placeOrder() {
  this.orderdetails.ord_billamount=this.orderdetails.ord_quantity*this.price;
  this._ordersService.placeOrder(this.orderdetails).subscribe(x => {
  this.msg = x;
  })
  alert("order placed")
}
  constructor(private _menuService:MenuService, private _vendorService:VendorsService,private _walletService:WalletService, private _ordersService:OrdersService) {
    this.orderdetails= new Orders();
    this.cus = localStorage.getItem('customerdata')? JSON.parse(localStorage.getItem('customerdata')):[];
    this.orderdetails.ocid=this.cus.cid;
    this.menu=this._menuService.showMenu();
    this.vendor=this._vendorService.showVendor();
    this.wallet=this._walletService.customerWallet(this.cus.cid);
   }
   showAmount(){
     this._menuService.searchMenu(this.orderdetails.omid).subscribe(x => {
       this.menufound = x;
       this.price = x.mprice;
     });
   }

   ngOnInit(): void {
    this.getDate();
  }

  todayDate : any
  todayDate1 : any

    getDate() {

      var date:any = new Date();
     
      var toDate:any = date.getDate();

      var toDate1:any = date.getDate();
     
      if(toDate < 10) {
     
      toDate = '0' + toDate;
     
      }
     
      var month: any  = date.getMonth() + 1;

      var months: any  = date.getMonth() + 1;
     
      if(month < 10){
     
      month= '0' + month;
     
      }
     
      var year = date.getFullYear();
      var year1 = date.getFullYear() ;
     
      this.todayDate = year + "-" + month + "-" +toDate
      this.todayDate1 = year1 + "-" + months + "-" +toDate1
      console.log(this.todayDate)
      console.log(this.todayDate1)
  }

}
