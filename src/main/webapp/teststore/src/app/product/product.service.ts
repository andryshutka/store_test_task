import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {PagedResponse} from "../helpers/paged-response-i";
import {Product} from "./product-i";

@Injectable()
export class ProductService {

  private readonly baseUrl;

  constructor(private http: HttpClient) {
    this.baseUrl = environment.baseUrl;
  }

  public getProducts(page: number, size: number): Observable<PagedResponse<Product>> {
    return this.http.get<PagedResponse<Product>>(this.baseUrl + `/api/products?page=${page}&size=${size}`);
  }

  public getProduct(id: number): Observable<Product> {
    return this.http.get<Product>(this.baseUrl + `/api/products/${id}`);
  }
}
