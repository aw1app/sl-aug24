import { Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { ProductListComponent } from './component/product-list/product-list.component';
import { AddProductComponent } from './component/add-product/add-product.component';
import { NotFoundComponent } from './component/not-found-component/not-found-component.component';

export const routes: Routes = [
    { path: '', component: AppComponent },

    { path: 'product-list', component: ProductListComponent },
    { path: 'add-product', component: AddProductComponent },

    { path: '*', component: NotFoundComponent },

];
