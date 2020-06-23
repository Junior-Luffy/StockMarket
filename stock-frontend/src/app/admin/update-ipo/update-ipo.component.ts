import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Ipo } from '../../models/ipo';
import { IpoService } from '../../service/ipo.service';

@Component({
  selector: 'app-update-ipo',
  templateUrl: './update-ipo.component.html',
  styleUrls: ['./update-ipo.component.css']
})
export class UpdateIpoComponent implements OnInit {
  loading = false;
  success = false;
  failed = false;
  @Input() ipo: Ipo;

  constructor(private route: ActivatedRoute, private router: Router, private ipoService: IpoService) { }

  ngOnInit() {
    this.ipo = new Ipo();
    const id = this.route.snapshot.params['id'];
    this.ipoService.getById(id).subscribe(
      (data: Ipo) => {
        this.ipo = data;
      }, error => { }
    );
  }

  update() {
    this.loading = true;
    this.ipoService.update(this.ipo).subscribe(
      (data: Ipo) => {
        this.loading = false;
        this.success = true;
        this.failed = false;
        this.router.navigate(['/admin/list-ipo']);
      }, error => {
        this.loading = false;
        this.success = false;
        this.failed = true;
      });
  }

}
