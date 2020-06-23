import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Company } from '../models/company';
import { Observable, throwError } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  constructor(private http: HttpClient) { }
  getCompanies() {
    return this.http.get(`${environment.gatewayurl}/api-company/company`);
  }

  getCompanyById(id: number) {
    return this.http.get(`${environment.gatewayurl}/api-company/company/` + id);
  }

  addCompany(company: Company) {
    return this.http.post(`${environment.gatewayurl}/api-company/company/save`, company);
  }

  updateCompany(company: Company) {
    return this.http.post(`${environment.gatewayurl}/api-company/company/save`, company);
  }

  deleteCompany(id: number) {
    return this.http.delete(`${environment.gatewayurl}/api-company/company/` + id);
  }
}
