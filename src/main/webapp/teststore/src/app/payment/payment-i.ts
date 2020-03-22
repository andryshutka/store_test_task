export interface Payment {
  id: string;
  productId: string;
  quantity: number;
  cardNumber: string;
  expiresIn: string
  cvv: number;
  paymentDate: Date;
  totalSum: number;
}
