import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Vendors } from '../vendors';
import { VendorsService } from '../vendors.service';
@Component({
  selector: 'app-vendors',
  templateUrl: './vendors.component.html',
  styleUrls: ['./vendors.component.css']
})
export class VendorsComponent implements OnInit {
  vendor : Observable<Vendors[]>;
  constructor(private _service : VendorsService) {
    this.vendor = this._service.showVendor();
   }

  ngOnInit(): void {
  }

}
