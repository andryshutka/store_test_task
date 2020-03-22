import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Payment} from "./payment-i";

@Injectable()
export class PaymentService {

  private readonly baseUrl;

  constructor(private http: HttpClient) {
    this.baseUrl = environment.baseUrl;
  }

  public createPayment(payment: Payment): Observable<Payment> {
    return this.http.post<Payment>(this.baseUrl + `/api/payments`, payment);
  }

}
