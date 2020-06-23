import { Component, OnInit, AfterViewInit } from '@angular/core';
import { ChartService } from '../../service/chart.service';
import { ChartDataSets, ChartOptions } from 'chart.js';
import { Color, Label, MultiDataSet } from 'ng2-charts';
import { ChartType } from 'chart.js';
import { StockPrice } from '../../models/stockprice';
import { LineChartItem } from '../../models/linechartitem';

@Component({
  selector: 'app-compare-charts',
  templateUrl: './compare-charts.component.html',
  styleUrls: ['./compare-charts.component.css']
})
export class CompareChartsComponent implements OnInit {

  lineChartData: ChartDataSets[] = [];

  lineChartItem: LineChartItem;

  lineChartLabels: Label[] = [];

  lineChartOptions = {
    responsive: true,
  };

  lineChartLegend = true;
  lineChartPlugins = [];
  lineChartType = 'line';  //bar,line

  stockpricesArray: StockPrice[][];

  constructor(private chartService: ChartService) { }

  ngOnInit() {
    this.lineChartType = this.chartService.charttype;

    for (const stockprices of this.chartService.stockpricesArray) {
      this.lineChartItem = new LineChartItem();
      this.lineChartItem.data = [];
      for (const stockprice of stockprices) {
        this.lineChartItem.data.push(stockprice.price);
        if (!this.lineChartItem.label) {
          this.lineChartItem.label = stockprice.companyname;
        }
        if (this.lineChartLabels.length < stockprices.length) {
          this.lineChartLabels.push(stockprice.date);
        }
      }
      this.lineChartData.push(this.lineChartItem);
    }
  }
}
