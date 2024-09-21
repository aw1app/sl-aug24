import { Component, OnInit } from '@angular/core';
import { Product } from '../../model/product';
import { ProductService } from '../../services/product.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'product-list',
  standalone: true,
  imports: [CommonModule],
  providers:[ProductService],
  templateUrl: './product-list.component.html',
  styleUrl: './product-list.component.css'
})
export class ProductListComponent implements OnInit{

  products: Product[] =[];

  productService!:ProductService;

  constructor( productService:ProductService){
  }

  ngOnInit():void {
    this.products = this.productService.getAllProducts();
  }

}
