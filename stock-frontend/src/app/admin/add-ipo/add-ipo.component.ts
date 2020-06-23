import { Component, OnInit, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Ipo } from '../../models/ipo';
import { IpoService } from '../../service/ipo.service';

@Component({
  selector: 'app-add-ipo',
  templateUrl: './add-ipo.component.html',
  styleUrls: ['./add-ipo.component.css']
})
export class AddIpoComponent implements OnInit {
  loading = false;
  success = false;
  failed = false;
  @Input() ipo: Ipo;

  constructor(private router: Router, private ipoiService: IpoService) { }

  ngOnInit() {
    this.ipo = new Ipo();
  }

  add() {
    this.loading = true;
    this.ipoiService.add(this.ipo).subscribe(
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

  reset() {
    this.ipo = new Ipo();
  }

}
