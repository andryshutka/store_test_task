import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HeaderComponent} from "./header/header.component";
import {MatToolbarModule} from "@angular/material/toolbar";
import {ProductListComponent} from "./product/list/product-list.component";
import {HttpClientModule} from "@angular/common/http";
import {ProductService} from "./product/product.service";
import {ProductItemComponent} from "./product/item/product-item.component";
import {MatListModule} from "@angular/material/list";
import {MatIconModule} from "@angular/material/icon";
import {PaymentFormComponent} from "./payment/form/payment-form.component";
import {MatInputModule} from "@angular/material/input";
import {FormsModule} from "@angular/forms";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {TextMaskModule} from "angular2-text-mask";
import {MatButtonModule} from "@angular/material/button";
import {PaymentService} from "./payment/payment.service";

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ProductListComponent,
    ProductItemComponent,
    PaymentFormComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatToolbarModule,
    MatListModule,
    MatIconModule,
    MatInputModule,
    MatButtonModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    TextMaskModule,
  ],
  providers: [
    ProductService,
    PaymentService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
