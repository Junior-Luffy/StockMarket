import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../../service/user.service';
import { User } from '../../models/user';

@Component({
  selector: 'app-update-details',
  templateUrl: './update-details.component.html',
  styleUrls: ['./update-details.component.css']
})
export class UpdateDetailsComponent implements OnInit {
  username: string;
  @Input() user: User = new User();

  constructor(private router: Router, private userService: UserService) { }

  ngOnInit() {
    this.username = this.username = JSON.parse(localStorage.getItem('currentUser')).username;
    this.userService.getByUsername(this.username).subscribe(
      (data: User) => {
        this.user = data;
      }, error => {

      }
    );
  }

  update() {
    this.userService.save(this.user).subscribe(
      data => {
        this.router.navigate(['/user/details']);
      }, error => {

      });
  }
}
