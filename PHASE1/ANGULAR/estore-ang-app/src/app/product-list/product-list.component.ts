import { Component } from '@angular/core';
import { Product } from '../product';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'product-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './product-list.component.html',
  styleUrl: './product-list.component.css'
})
export class ProductListComponent {

  products!: Product[];

  constructor() {

    this.products = [];
    this.products[0] = new Product("iPhone", 75000, "Great Phone", true, 'images/111.png');
    this.products[1] = new Product("Nokia", 5000, "Simple Phone", true, 'images/222.png');
    this.products[2] = new Product("Samsung", 15000, "Good Phone", true, 'images/333.png');
    this.products[3] = new Product("Motorala", 25000, "Nice Phone", false, 'images/444.png');

  }

}

//CHALLENGE: Display the products in a nice table
