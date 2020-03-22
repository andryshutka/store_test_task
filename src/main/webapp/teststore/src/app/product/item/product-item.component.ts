import {Component, Input, OnInit} from "@angular/core";
import {Product} from "../product-i";
import {Router} from "@angular/router";

@Component({
  selector: 'app-product-item',
  templateUrl: './product-item.component.html',
  styleUrls: ['./product-item.component.scss']
})
export class ProductItemComponent implements OnInit {

  constructor(private router: Router) {
  }

  @Input() public product: Product;

  ngOnInit(): void {
  }

  public buyProduct(product) {
    this.router.navigate([`buy/${product.id}`]);
  }

}
