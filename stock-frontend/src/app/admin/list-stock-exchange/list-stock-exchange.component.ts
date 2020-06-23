import { Component, OnInit } from '@angular/core';
import { StockExchange } from '../../models/stockexchange';
import { StockService } from '../../service/stock.service';

@Component({
  selector: 'app-list-stock-exchange',
  templateUrl: './list-stock-exchange.component.html',
  styleUrls: ['./list-stock-exchange.component.css']
})
export class ListStockExchangeComponent implements OnInit {
  stockexchanges: StockExchange[];

  constructor(private stockService: StockService ) { }

  ngOnInit() {
    this.stockService.getAll().subscribe(
      (data: StockExchange[]) => {
        this.stockexchanges = data;
      }, error => {
      });
  }

  delete(id: number) {
    this.stockService.delete(id).subscribe(
      data => {
        this.ngOnInit();
      }, error => {
      });
  }

}
