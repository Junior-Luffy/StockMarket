import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  username: string;
  role: string;
  constructor() { }

  ngOnInit() {
    this.username = JSON.parse(localStorage.getItem('currentUser')).username;
    this.role = JSON.parse(localStorage.getItem('currentUser')).role;
  }

}
