import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthComponent } from './components/auth/auth.component';
import { FormsModule } from '@angular/forms';
import { HomeComponent } from './components/home/home.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { JobsComponent } from './components/jobs/jobs.component';
import { MyOffersComponent } from './components/my-offers/my-offers.component';
import { MyApplicationsComponent } from './components/my-applications/my-applications.component';
import { CandidatesComponent } from './components/candidates/candidates.component';

@NgModule({
  declarations: [
    AppComponent,
    AuthComponent,
    HomeComponent,
    SidebarComponent,
    JobsComponent,
    MyOffersComponent,
    MyApplicationsComponent,
    CandidatesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
