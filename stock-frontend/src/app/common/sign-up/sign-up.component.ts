import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../../models/user';
import { UserService } from '../../service/user.service';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  loading = false;
  registerSucceed = false;
  registerFailed = false;
  message: string;

  @Input() user: User;

  constructor(private router: Router, private userService: UserService) { }

  ngOnInit() {
    this.user = new User();
    this.user.role = 'user';
  }

  signup(): void {
    this.loading = true;
    this.registerFailed = false;
    this.userService.addUser(this.user)
      .pipe(first())
      .subscribe(
        data => {
          this.registerSucceed = true;
          this.loading = false;
        },
        error => {
          this.registerFailed = true;
          this.loading = false;
        });
  }

}
