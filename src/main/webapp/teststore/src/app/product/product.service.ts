import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {ProductListResponse} from "./product-list-response-i";

@Injectable()
export class ProductService {

  private readonly baseUrl;

  constructor(private http: HttpClient) {
    this.baseUrl = environment.baseUrl;
  }

  public getProducts(): Observable<ProductListResponse> {
    return this.http.get<ProductListResponse>(this.baseUrl + "/api/products");
  }
}
