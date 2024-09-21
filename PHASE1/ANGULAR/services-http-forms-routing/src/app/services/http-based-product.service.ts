import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class HttpBasedProductService {

  apiBaseUrl:string = "http://localhost:3000/products"


  constructor(private http: HttpClient) { }

  getAllProducts():Observable<Product[]> {  
    return this.http.get<Product[]>(this.apiBaseUrl);   
   }

   //CHALLENGE: Enhance the HTTPbased product service that will delete a product from the products.
   deleteProduct(id:number):Observable<void> {  
     return this.http.delete<void>(this.apiBaseUrl+"/"+id);   
   }



}
