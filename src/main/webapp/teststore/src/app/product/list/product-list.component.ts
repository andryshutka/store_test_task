import {Component, OnInit} from "@angular/core";
import {ProductService} from "../product.service";
import {Product} from "../product-i";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.scss']
})
export class ProductListComponent implements OnInit{

  public products: Product[] = [];
  public hasMoreElements: Boolean = true;
  private page: number = 0;
  private size: number = 10;

  constructor(private productService: ProductService) {
  }

  ngOnInit(): void {
    this.loadProducts();
  }

  public loadMore() {
    if (this.hasMoreElements) {
      ++this.page;
      this.loadProducts();
    }
  }

  private loadProducts() {
    this.productService.getProducts(this.page, this.size).subscribe(products => {
      this.products = this.products.concat(products.elements);
      if (((this.page + 1) * this.size) > products.totalElements) {
        this.hasMoreElements = false;
      }
    })
  }



  public resolveClass(product) {
    let baseName = 'product-list-item';
    if (product.count > 10) {
      baseName += ' many';
    }
    if (product.count > 0 && product.count <= 10) {
      baseName += ' few';
    }
    if (product.count == 0) {
      baseName += ' none';
    }
    return baseName;
  }

  public resolveTitle(product) {
    let title = '';
    if (product.count > 10) {
      title = 'We have many of these.';
    }
    if (product.count > 0 && product.count <= 10) {
      title = 'Hurry up! There are a few left.';
    }
    if (product.count == 0) {
      title = 'All sold :(';
    }
    return title;
  }
}
