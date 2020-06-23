import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { Compare } from '../models/compare';
import { StockPrice } from '../models/stockprice';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ChartService {
  stockpricesArray: StockPrice[][] = [];

  charttype: string;

  constructor(private http: HttpClient) { }

  query(query: Compare): Observable<StockPrice[]> {
    return this.http.post<StockPrice[]>(`${environment.gatewayurl}/api-company/stockprice/query`, query);
  }
}
