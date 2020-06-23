import { Component, OnInit, Input } from '@angular/core';
import { ChartService } from '../../service/chart.service';
import { Compare } from '../../models/compare';
import { Router } from '@angular/router';
import { StockPrice } from '../../models/stockprice';

@Component({
  selector: 'app-compare-details',
  templateUrl: './compare-details.component.html',
  styleUrls: ['./compare-details.component.css']
})
export class CompareDetailsComponent implements OnInit {

  divs: number[] = [];
  @Input() compare: Compare;
  stockprices: StockPrice[];

  constructor(private router: Router, private chartService: ChartService) { }

  ngOnInit() {
    this.compare = new Compare();
    this.compare.charttype = 'line';
    this.compare.companynames = [];
    this.compare.companynames.push('');
    this.chartService.stockpricesArray = [];
  }

  createDiv(): void {
    this.compare.companynames.push('');
  }

  generate() {
    this.chartService.charttype = this.compare.charttype;
    this.chartService.query(this.compare).subscribe(
      (data: []) => {
        for (const item of data) {
          this.chartService.stockpricesArray.push(item);
        }
        this.router.navigateByUrl('/user/compare-chart');
      }, error => {
      }
    );

  }

  indexTracker(index: number, value: any) {
    return index;
  }

}
