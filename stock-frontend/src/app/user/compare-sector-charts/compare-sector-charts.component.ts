import { Component, OnInit } from '@angular/core';
import { ChartType, ChartOptions } from 'chart.js';
import { SingleDataSet, Label, monkeyPatchChartJsLegend, monkeyPatchChartJsTooltip } from 'ng2-charts';

@Component({
  selector: 'app-compare-sector-charts',
  templateUrl: './compare-sector-charts.component.html',
  styleUrls: ['./compare-sector-charts.component.css']
})
export class CompareSectorChartsComponent implements OnInit {

  public pieChartOptions: ChartOptions = {
    responsive: true,
  };
  public pieChartLabels: Label[] = ['IT', 'Security', 'Finance', 'Education'];
  public pieChartData: SingleDataSet = [30, 50, 20,10];
  public pieChartType: ChartType = 'pie';
  public pieChartLegend = true;
  public pieChartPlugins = [];

  constructor() {
    monkeyPatchChartJsTooltip();
    monkeyPatchChartJsLegend();
  }

  ngOnInit() {
  }

}
