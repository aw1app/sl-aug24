import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ProductComponent } from "./product/product.component";

import { ProductListComponent } from "./product-list/product-list.component";



@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ProductComponent, ProductListComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'estore-ang-app';

  x:number  = 10;
  enabled:boolean = false;

  w:number=50;
h:number=100;

}
