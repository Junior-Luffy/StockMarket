import { Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  username: string;
  role: string;
  constructor() { }

  ngOnInit() {
    this.username = JSON.parse(localStorage.getItem('currentUser')).username;
    this.role = JSON.parse(localStorage.getItem('currentUser')).role;
  }

}
