import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthComponent } from './components/auth/auth.component';
import { HomeComponent } from './components/home/home.component';
import { JobsComponent } from './components/jobs/jobs.component';
import { MyApplicationsComponent } from './components/my-applications/my-applications.component';
import { MyOffersComponent } from './components/my-offers/my-offers.component';

const routes: Routes = [
  {path:'', redirectTo: 'login', pathMatch: 'full'},
  {path:'login', component: AuthComponent},
  {
    path:'home', 
    component: HomeComponent,
    children:[
      {path: '', redirectTo: 'jobs', pathMatch: 'full'},
      {path:'jobs', component: JobsComponent},
      {path:'myApplications', component: MyApplicationsComponent},
      {path:'myOffers', component: MyOffersComponent}
    ]
  }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
