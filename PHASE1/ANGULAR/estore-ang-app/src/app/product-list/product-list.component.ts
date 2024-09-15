import { Component } from '@angular/core';
import { Product } from '../product';

@Component({
  selector: 'product-list',
  standalone: true,
  imports: [],
  templateUrl: './product-list.component.html',
  styleUrl: './product-list.component.css'
})
export class ProductListComponent {

products!:Product[];

constructor(){
  
  this.products = [];
  this.products[0] = new Product("iPhone", 75000, "Great Phone", true, '');
  this.products[1] = new Product("Nokia", 5000, "Great Phone", true, '');
  this.products[2] = new Product("Samsung", 15000, "Great Phone", true, '');
  this.products[3] = new Product("Motorala", 25000, "Great Phone", false, '');

}

}
