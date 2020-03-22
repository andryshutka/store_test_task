import {Component, OnInit} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {ProductService} from "../../product/product.service";
import {Product} from "../../product/product-i";
import {Payment} from "../payment-i";
import {PaymentService} from "../payment.service";

@Component({
  selector: 'app-payment-form',
  templateUrl: './payment-form.component.html',
  styleUrls: ['./payment-form.component.scss']
})
export class PaymentFormComponent implements OnInit {

  private productId: number;
  public productToBuy: Product = <Product>{};
  public totalCount: number = 1;
  public totalSum: number;
  public payment: Payment = <Payment>{
    quantity: 1
  };

  public yearMonthMask =  [/\d/, /\d/, '/', /\d/, /\d/];
  public cvvMask =  [/\d/, /\d/, /\d/];
  public cardNumberMask =  [/\d/, /\d/, /\d/, /\d/, ' ', /\d/, /\d/, /\d/, /\d/, ' ',/\d/, /\d/, /\d/, /\d/, ' ',/\d/, /\d/, /\d/, /\d/];

  constructor(private route: ActivatedRoute,
              private router: Router,
              private productService: ProductService,
              private paymentService: PaymentService) {
  }

  ngOnInit(): void {
      this.route.params.subscribe( params => {
        this.productId = params['productId'];
        this.productService.getProduct(this.productId).subscribe(product => {
          this.productToBuy = product;
          this.totalSum = this.productToBuy.price;
        });
      });
  }

  public buy() {
    this.payment.totalSum = this.totalSum;
    this.payment.productId = this.productToBuy.id;
    this.paymentService.createPayment(this.payment).subscribe(payment => {
      if (payment.id) {
        console.log('payment successful');
        this.router.navigate(['']);
      }
    })
  }

  public isValid() {
    return this.payment.quantity && this.payment.cardNumber && this.payment.expiresIn && this.payment.cvv;
  }
}
