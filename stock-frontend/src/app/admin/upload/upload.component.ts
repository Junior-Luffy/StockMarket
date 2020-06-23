import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs/operators';
import { UploadService } from '../../service/upload.service';
import { ImportInfo } from '../../models/importinfo';

@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.css']
})
export class UploadComponent implements OnInit {

  attachment: File;
  importinfo: ImportInfo;
  loading = false;
  imported = false;

  constructor(private uploadService: UploadService) { }

  ngOnInit() {
    this.importinfo = new ImportInfo();
  }

  getUpload(e) {
    if (e.target.files[0]) {
      this.attachment = e.target.files[0];
    }
  }

  onSubmit() {
    this.loading = true;
    const formData = new FormData();
    formData.append('file', this.attachment);
    this.uploadService.upload(formData).pipe(first()).subscribe(data => {
      this.loading = false;
      this.imported = true;
      this.importinfo.companycode = data['companycode'];
      this.importinfo.stockexchange = data['stockexchange'];
      this.importinfo.totalnumbers = data['totalnumbers'];
      this.importinfo.starttime = data['starttime'];
      this.importinfo.endtime = data['endtime'];
    },
      error => {

      });
  }

}
