import { Component, OnInit } from '@angular/core';
import { Ipo } from '../../models/ipo';
import { IpoService } from '../../service/ipo.service';

@Component({
  selector: 'app-ipo-list',
  templateUrl: './ipo-list.component.html',
  styleUrls: ['./ipo-list.component.css']
})
export class IpoListComponent implements OnInit {

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
