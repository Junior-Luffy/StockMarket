import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-compare-sector-details',
  templateUrl: './compare-sector-details.component.html',
  styleUrls: ['./compare-sector-details.component.css']
})
export class CompareSectorDetailsComponent implements OnInit {

  divs: number[] = [];

  constructor(private router: Router) { }

  ngOnInit() {
  }

  createDiv(): void {
    this.divs.push(this.divs.length);
  }

  indexTracker(index: number, value: any) {
    return index;
  }

  generate() {
    this.router.navigateByUrl('/user/compare-sector-chart');
  }

}
