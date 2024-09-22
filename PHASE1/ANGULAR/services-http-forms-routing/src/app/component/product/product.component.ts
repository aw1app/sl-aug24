import { Component, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from '../../model/product';
import { HttpBasedProductService } from '../../services/http-based-product.service';

@Component({
  selector: 'app-product',
  standalone: true,
  imports: [],
  templateUrl: './product.component.html',
  styleUrl: './product.component.css'
})
export class ProductComponent {
  
  product!: Product;
  httpbasedProductService!: HttpBasedProductService;
  route!: ActivatedRoute;

  @Input('productId') productId!: string;

  constructor(httpbasedProductService: HttpBasedProductService, route: ActivatedRoute) {
    this.httpbasedProductService = httpbasedProductService;
    this.route = route;
  }


  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      console.log(params.get('productId'));
      
      const productId = params.get('productId');
      if (productId !== null) {
        this.productId = productId;
        
        // Now you can use this.productId to fetch it from the Service
        this.httpbasedProductService.getProduct(this.productId).subscribe(
          product => {
            this.product = product;
          },
          error => {
            console.error('Error fetching product:', error);
          }
        );
      }
    });
  }



}
