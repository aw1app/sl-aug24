import { Component } from '@angular/core';
import { Product } from '../product';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators  } from '@angular/forms';

@Component({
  selector: 'product-list',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './product-list.component.html',
  styleUrl: './product-list.component.css'
})
export class ProductListComponent {

  products!: Product[];

  abc:FormControl = new FormControl();

  constructor() {

    this.products = [];
    this.products[0] = new Product(1,"iPhone", 75000, "Great Phone", true, 'images/111.png');
    this.products[1] = new Product(2,"Nokia", 5000, "Simple Phone", true, 'images/222.png');
    this.products[2] = new Product(3,"Samsung", 15000, "Good Phone", true, 'images/333.png');
    this.products[3] = new Product(4,"Motorala", 25000, "Nice Phone", false, 'images/444.png');

  }

  addToCart(prod:Product):void{
   console.log(" Inside addToCart() of ProductListComponent"); 
   console.log(`Add ${prod.name} to the Cart`);      
  }

  changePrice(prod:Product) {
    prod.price = prod.price - (prod.price * (1 / 10));
  }

}

//CHALLENGE: Display the products in a nice table
