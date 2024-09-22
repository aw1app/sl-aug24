import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpBasedProductService } from '../../services/http-based-product.service';

@Component({
  selector: 'app-add-product',
  standalone: true,
  imports: [CommonModule,ReactiveFormsModule],
  providers: [HttpBasedProductService],
  templateUrl: './add-product.component.html',
  styleUrl: './add-product.component.css'
})
export class AddProductComponent {

  productForm!:FormGroup;
  httpbasedProductService!: HttpBasedProductService;

  constructor(private fb: FormBuilder, httpbasedProductService: HttpBasedProductService){
    this.httpbasedProductService = httpbasedProductService;

    this.productForm = this.fb.group(

      {
        productName:[''],
        productPrice:[0],
      }

    );
  }  


  addProduct():void{

  }

}
