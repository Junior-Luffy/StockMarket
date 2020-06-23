import { Component, OnInit, Input } from '@angular/core';
import { UserService } from '../../service/user.service';
import { User } from '../../models/user';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {

  username: string;
  @Input() user: User = new User();

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.username = JSON.parse(localStorage.getItem('currentUser')).username;
    this.userService.getByUsername(this.username).subscribe(
      (data: User) => {
        this.user = data;
      }, error => {

      }
    );
  }

}
