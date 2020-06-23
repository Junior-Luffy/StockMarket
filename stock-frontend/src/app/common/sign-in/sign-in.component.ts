import { Component, OnInit, Input } from '@angular/core';
import { AuthService } from '../../service/auth.service';
import { AlertService } from '../../service/alert.service';
import { Router, ActivatedRoute } from '@angular/router';
import { first } from 'rxjs/operators';
import { User } from '../../models/user';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {
  invalid = false;
  loading = false;
  @Input() user: User;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private alertService: AlertService,
    private authenticationService: AuthService,
  ) { }

  ngOnInit() {
    this.user = new User();
  }

  login() {
    this.loading = true;
    this.authenticationService.login(this.user.username, this.user.password)
      .pipe(first())
      .subscribe(
        data => {
          if ( data.role === 'admin') {
            this.router.navigate(['/admin']);
          } else {
            this.router.navigate(['/user']);
          }
        },
        error => {
          this.invalid = true;
          this.loading = false;
          this.user.password = '';
        });
  }

  signup(): void {
    this.router.navigateByUrl('/sign-up');
  }

}
