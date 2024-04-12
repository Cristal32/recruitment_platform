import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthComponent } from './components/auth/auth.component';
import { HomeComponent } from './components/home/home.component';

const routes: Routes = [
  {path:'', redirectTo: 'login', pathMatch: 'full'},
  {path:'login', component: AuthComponent},
  {
    path:'home', 
    component: HomeComponent,
    // children:[
    //   //{path: '', redirectTo: 'stagiaires', pathMatch: 'full'},
    //   {path:'stagiaires', component: StagiairesComponent},
    //   {path:'utilisateur', component: UtilisateurComponent},
    //   {path:'roles',component: RolesComponent},
    //   {path:'access',component: AccessComponent},
    //   {path:'stages',component: StagesComponent},
    //   {path:'affectations',component: AffectationsComponent},
    //   {path:'messages',component: MessagesComponent}
    // ]
  }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
