import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Ipo } from '../models/ipo';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class IpoService {

  constructor(private http: HttpClient) { }

  getAll() {
    return this.http.get(`${environment.gatewayurl}/api-company/ipo`);
  }

  getById(id: number) {
    return this.http.get(`${environment.gatewayurl}/api-company/ipo/` + id);
  }

  add(ipo: Ipo) {
    return this.http.post(`${environment.gatewayurl}/api-company/ipo/save`, ipo);
  }

  update(ipo: Ipo) {
    return this.http.post(`${environment.gatewayurl}/api-company/ipo/save`, ipo);
  }

  delete(id: number) {
    return this.http.delete(`${environment.gatewayurl}/api-company/ipo/` + id);
  }
}
