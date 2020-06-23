import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { CompanyService } from '../../service/company.service';
import { Company } from '../../models/company';

@Component({
  selector: 'app-update-company',
  templateUrl: './update-company.component.html',
  styleUrls: ['./update-company.component.css']
})
export class UpdateCompanyComponent implements OnInit {
  loading = false;
  success = false;
  failed = false;
  @Input() company: Company;

  constructor(private route: ActivatedRoute, private router: Router, private companyService: CompanyService) { }

  ngOnInit() {
    this.company = new Company();
    const id = this.route.snapshot.params['id'];
    this.companyService.getCompanyById(id).subscribe(
      (data: Company) => {
        this.company = data;
      }, error => { }
    );
  }

  update() {
    this.loading = true;
    this.companyService.updateCompany(this.company).subscribe(
      (data: Company) => {
        this.loading = false;
        this.success = true;
        this.failed = false;
        this.router.navigate(['/admin/list-company']);
      }, error => {
        this.loading = false;
        this.success = false;
        this.failed = true;
      });
  }

}
