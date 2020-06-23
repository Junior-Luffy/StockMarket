import { Component, OnInit } from '@angular/core';
import { Company } from '../../models/company';
import { CompanyService } from '../../service/company.service';

@Component({
  selector: 'app-list-company',
  templateUrl: './list-company.component.html',
  styleUrls: ['./list-company.component.css']
})
export class ListCompanyComponent implements OnInit {
  companies: Company[];

  constructor(private companyService: CompanyService) { }

  ngOnInit() {
    this.companyService.getCompanies().subscribe(
      (data: Company[]) => {
        this.companies = data;
      }, error => {
      });
  }

}
