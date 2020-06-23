import { Component, OnInit, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { StockExchange } from '../../models/stockexchange';
import { StockService } from '../../service/stock.service';

@Component({
  selector: 'app-add-stock-exchange',
  templateUrl: './add-stock-exchange.component.html',
  styleUrls: ['./add-stock-exchange.component.css']
})
export class AddStockExchangeComponent implements OnInit {

  loading = false;
  success = false;
  failed = false;

  @Input() stockExchange: StockExchange;

  constructor(private router: Router, private stockService: StockService) { }

  ngOnInit() {
    this.stockExchange = new StockExchange();
  }

  add() {
    this.loading = true;
    this.stockService.add(this.stockExchange).subscribe(
      (data: StockExchange) => {
        this.loading = false;
        this.success = true;
        this.failed = false;
        this.router.navigate(['/admin/list-stockexchange']);
      }, error => {
        this.loading = false;
        this.success = false;
        this.failed = true;
      });
  }

  reset() {
    this.stockExchange = new StockExchange();
  }

}
