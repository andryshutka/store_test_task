export interface PagedResponse<T> {
  page: number;
  totalElements: number;
  elements: T[];
}
