import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UploadService {

  constructor(private http: HttpClient) { }

  upload(form: FormData) {
    return this.http.post(`${environment.gatewayurl}/api-attachement/stockprice/attachment`, form);
   }
}
