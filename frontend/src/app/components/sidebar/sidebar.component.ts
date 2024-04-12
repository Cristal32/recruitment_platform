import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  currentUser: any;
  currentUtilisateur: User = new User();
  constructor(private router: Router) { }
  // constructor(private router: Router, private utilisateurService: UtilisateurService,private authService: AuthService) { }

  ngOnInit(): void {
      // this.currentUser = JSON.parse(localStorage.getItem('currentUser')|| '{}');
      // this.getCurrentUser();
  }

  logout(){
    // this.authService.logout();
    this.router.navigate(['login']);
  }

  getCurrentUser(){
    // return this.utilisateurService.getUtilisateurById(this.currentUser.userId).subscribe(
    //   data => {
    //     this.currentUtilisateur = data;
    //   },
    //   (error: HttpErrorResponse) => {
    //     console.log(error)
    //   }
    // );
  }
}
