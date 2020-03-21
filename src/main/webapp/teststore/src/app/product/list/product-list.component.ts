import {Component, OnInit} from "@angular/core";
import {ProductService} from "../product.service";
import {Product} from "../product-i";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.scss']
})
export class ProductListComponent implements OnInit{

  public products: Product[];

  constructor(private productService: ProductService) {
  }

  ngOnInit(): void {
    this.productService.getProducts().subscribe(products => {
      this.products = products.elements;
      console.log(this.products);
    })
  }
}
