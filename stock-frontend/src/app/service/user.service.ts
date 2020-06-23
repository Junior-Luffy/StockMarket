import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/user';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  addUser(user: User) {
    return this.http.post(`${environment.gatewayurl}/api-user/user/save`, user);
  }

  save(user: User) {
    return this.http.post(`${environment.gatewayurl}/api-user/user/save`, user);
  }

  getByUsername(username: string) {
    return this.http.get(`${environment.gatewayurl}/api-user/username/` + username);
  }
}
