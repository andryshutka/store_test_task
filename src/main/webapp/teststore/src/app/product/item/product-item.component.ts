import {Component, Input, OnInit} from "@angular/core";
import {Product} from "../product-i";

@Component({
  selector: 'app-product-item',
  templateUrl: './product-item.component.html',
  styleUrls: ['./product-item.component.scss']
})
export class ProductItemComponent implements OnInit {

  @Input() public products: Product;

  ngOnInit(): void {
  }

}
