import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { SignInComponent } from './common/sign-in/sign-in.component';
import { SignUpComponent } from './common/sign-up/sign-up.component';
import { UserComponent } from './user/user/user.component';
import { UpdateDetailsComponent } from './user/update-details/update-details.component';
import { ListIpoComponent } from './user/list-ipo/list-ipo.component';
import { DetailsComponent } from './user/details/details.component';
import { CompareDetailsComponent } from './user/compare-details/compare-details.component';
import { AddCompanyComponent } from './admin/add-company/add-company.component';
import { AddStockExchangeComponent } from './admin/add-stock-exchange/add-stock-exchange.component';
import { AdminComponent } from './admin/admin/admin.component';
import { ListCompanyComponent } from './admin/list-company/list-company.component';
import { UpdateCompanyComponent } from './admin/update-company/update-company.component';
import { UpdateIpoComponent } from './admin/update-ipo/update-ipo.component';
import { UploadComponent } from './admin/upload/upload.component';
import { ListStockExchangeComponent } from './admin/list-stock-exchange/list-stock-exchange.component';
import { IpoListComponent } from './admin/ipo-list/ipo-list.component';
import { AddIpoComponent } from './admin/add-ipo/add-ipo.component';
import { CompareSectorDetailsComponent } from './user/compare-sector-details/compare-sector-details.component';
import { CompareChartsComponent } from './user/compare-charts/compare-charts.component';
import { CompareSectorChartsComponent } from './user/compare-sector-charts/compare-sector-charts.component';


const routes: Routes = [{ path: '', redirectTo: 'sign-in', pathMatch: 'full' },
{ path: 'sign-in', component: SignInComponent },
{ path: 'sign-up', component: SignUpComponent },
{
  path: 'admin', component: AdminComponent,
  children: [
    { path: '', component: UploadComponent },
    { path: 'upload', component: UploadComponent },
    { path: 'add-company', component: AddCompanyComponent },
    { path: 'update-company/:id', component: UpdateCompanyComponent },
    { path: 'add-stock-exchange', component: AddStockExchangeComponent },
    { path: 'list-company', component: ListCompanyComponent },
    { path: 'list-stockexchange', component: ListStockExchangeComponent },
    { path: 'list-ipo', component: IpoListComponent },
    { path: 'add-ipo', component: AddIpoComponent },
    { path: 'update-ipo/:id', component: UpdateIpoComponent }
  ]
},
{
  path: 'user', component: UserComponent,
  children: [
    { path: '', component: ListIpoComponent },
    { path: 'details', component: DetailsComponent },
    { path: 'update-user', component: UpdateDetailsComponent },
    { path: 'list-ipo', component: ListIpoComponent },
    { path: 'compare-details', component: CompareDetailsComponent },
    { path: 'compare-sector-details', component: CompareSectorDetailsComponent },
    { path: 'compare-chart', component: CompareChartsComponent },
    { path: 'compare-sector-chart', component: CompareSectorChartsComponent }
  ]
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
