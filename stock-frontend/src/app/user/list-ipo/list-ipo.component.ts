import { Component, OnInit } from '@angular/core';
import { Ipo } from '../../models/ipo';
import { IpoService } from '../../service/ipo.service';

@Component({
  selector: 'app-list-ipo',
  templateUrl: './list-ipo.component.html',
  styleUrls: ['./list-ipo.component.css']
})
export class ListIpoComponent implements OnInit {
  ipos: Ipo[];

  constructor(private ipoService: IpoService) { }

  ngOnInit() {
    this.ipoService.getAll().subscribe(
      (data: Ipo[]) => {
        this.ipos = data;
      }, error => {
      });
  }

}
