import {Product} from "./product-i";

export interface ProductListResponse {
  page: number;
  totalElements: number;
  elements: Product[];
}
