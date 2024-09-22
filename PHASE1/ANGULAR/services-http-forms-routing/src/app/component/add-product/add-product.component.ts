import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpBasedProductService } from '../../services/http-based-product.service';
import { Product } from '../../model/product';

@Component({
  selector: 'add-product',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  providers: [HttpBasedProductService],
  templateUrl: './add-product.component.html',
  styleUrl: './add-product.component.css'
})
export class AddProductComponent {

  productForm!: FormGroup;
  httpbasedProductService!: HttpBasedProductService;

  constructor(private fb: FormBuilder, httpbasedProductService: HttpBasedProductService) {
    this.httpbasedProductService = httpbasedProductService;

    this.productForm = this.fb.group(

      {
        productName: [''],
        productPrice: [0],
      }

    );
  }


  addProduct(): void {
    let name = this.productForm.get('productName')?.value;
    let price = this.productForm.get('productPrice')?.value;

    let tempProduct = new Product(0, name, price, '', true, 'images/444.png');

    this.httpbasedProductService.addProduct(tempProduct).subscribe(

      (newProd) => console.log("Add a new Product . It's id = " + newProd.id)

    )
  }

}
