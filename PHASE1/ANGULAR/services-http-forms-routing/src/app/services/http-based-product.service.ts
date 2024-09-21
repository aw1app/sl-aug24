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


}
