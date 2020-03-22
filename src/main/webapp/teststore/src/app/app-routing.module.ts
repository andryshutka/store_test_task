import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {PaymentFormComponent} from "./payment/form/payment-form.component";
import {ProductListComponent} from "./product/list/product-list.component";
import {ThankYouComponent} from "./payment/thankyou/thank-you.component";


const routes: Routes = [
  {path: 'buy/:productId' , component: PaymentFormComponent},
  {path: 'thank-you' , component: ThankYouComponent},
  {path: '' , component: ProductListComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
