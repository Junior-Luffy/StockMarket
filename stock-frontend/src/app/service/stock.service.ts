import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { StockExchange } from '../models/stockexchange';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class StockService {

  constructor(private http: HttpClient) { }

  getAll() {
    return this.http.get(`${environment.gatewayurl}/api-company/stockexchange`);
  }

  add(stockexchange: StockExchange) {
    return this.http.post(`${environment.gatewayurl}/api-company/stockexchange/save`, stockexchange);
  }

  delete(id: number) {
    return this.http.delete(`${environment.gatewayurl}/api-company/stockexchange/` + id);
  }

}
