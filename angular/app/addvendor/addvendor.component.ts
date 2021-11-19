import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Vendors } from '../vendors';
import { VendorsService } from '../vendors.service';

@Component({
  selector: 'app-addvendor',
  templateUrl: './addvendor.component.html',
  styleUrls: ['./addvendor.component.css']
})
export class AddvendorComponent implements OnInit {
  addven:Vendors;
  ven:Observable<Vendors[]>
  price:number;
  msg: string;
    addvendor() {
      this._vendorService.addvendor(this.addven).subscribe(x => {
      this.msg = x;
      })
      alert("account created successfully")
    }
      constructor(private _vendorService:VendorsService) {
        this.addven= new Vendors();
       }
  ngOnInit(): void {
  }

}
