import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SignInComponent } from './common/sign-in/sign-in.component';
import { SignUpComponent } from './common/sign-up/sign-up.component';
import { FooterComponent } from './common/footer/footer.component';
import { HeaderComponent } from './common/header/header.component';
import { UserComponent } from './user/user/user.component';
import { UpdateDetailsComponent } from './user/update-details/update-details.component';
import { DetailsComponent } from './user/details/details.component';
import { CompareDetailsComponent } from './user/compare-details/compare-details.component';
import { CompareChartsComponent } from './user/compare-charts/compare-charts.component';
import { AddCompanyComponent } from './admin/add-company/add-company.component';
import { AddStockExchangeComponent } from './admin/add-stock-exchange/add-stock-exchange.component';
import { AdminComponent } from './admin/admin/admin.component';
import { IpoListComponent } from './admin/ipo-list/ipo-list.component';
import { ListCompanyComponent } from './admin/list-company/list-company.component';
import { UpdateCompanyComponent } from './admin/update-company/update-company.component';
import { UpdateIpoComponent } from './admin/update-ipo/update-ipo.component';
import { UploadComponent } from './admin/upload/upload.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { MessageComponent } from './common/message/message.component';
import {BsDropdownModule} from 'ngx-bootstrap/dropdown';
import { ListStockExchangeComponent } from './admin/list-stock-exchange/list-stock-exchange.component';
import { AddIpoComponent } from './admin/add-ipo/add-ipo.component';
import { CompareSectorDetailsComponent } from './user/compare-sector-details/compare-sector-details.component';
import { ChartsModule } from 'ng2-charts';
import { CompareSectorChartsComponent } from './user/compare-sector-charts/compare-sector-charts.component';
import { ListIpoComponent } from './user/list-ipo/list-ipo.component';
import { JwtInterceptor } from './interceptor/jwt.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    SignInComponent,
    SignUpComponent,
    FooterComponent,
    HeaderComponent,
    UserComponent,
    UpdateDetailsComponent,
    DetailsComponent,
    CompareDetailsComponent,
    CompareChartsComponent,
    AddCompanyComponent,
    AddStockExchangeComponent,
    AdminComponent,
    IpoListComponent,
    ListCompanyComponent,
    UpdateCompanyComponent,
    UpdateIpoComponent,
    UploadComponent,
    MessageComponent,
    ListStockExchangeComponent,
    AddIpoComponent,
    CompareSectorDetailsComponent,
    CompareSectorChartsComponent,
    ListIpoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    ChartsModule,
    BsDropdownModule.forRoot()
  ],
  providers: [{ provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true }],
  bootstrap: [AppComponent]
})
export class AppModule { }
