import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {PaymentFormComponent} from "./payment/form/payment-form.component";
import {ProductListComponent} from "./product/list/product-list.component";


const routes: Routes = [
  {path: 'buy/:productId' , component: PaymentFormComponent},
  {path: '' , component: ProductListComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
