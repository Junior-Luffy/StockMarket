import { Component, OnInit, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Company } from '../../models/company';
import { CompanyService } from '../../service/company.service';

@Component({
  selector: 'app-add-company',
  templateUrl: './add-company.component.html',
  styleUrls: ['./add-company.component.css']
})
export class AddCompanyComponent implements OnInit {
  loading = false;
  success = false;
  failed = false;
  @Input() company: Company;

  constructor(private router: Router, private companyService: CompanyService) { }

  ngOnInit() {
    this.company = new Company();
  }

  add() {
    this.loading = true;
    this.companyService.addCompany(this.company).subscribe(
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

  reset() {
    this.company = new Company();
  }

}
