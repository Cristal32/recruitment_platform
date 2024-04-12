import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit {
  currentUtilisateur: User = new User();

  form: any = {
    username: null,
    password: null
  };
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  
  // constructor(private router: Router, private authService: AuthService, private tokenStorageService: TokenStorageService, private utilisateurService: UtilisateurService) { }
  constructor(private router: Router) { }

  ngOnInit(): void {
    //loged in user
    //console.log(JSON.parse(localStorage.getItem('currentUser')|| '{}'));
  }

  getCurrentUtilisateur(){
    return null;
  //   return this.tokenStorageService.getCurrentUtilisateur();
  }

  onSubmit() {
    this.router.navigate(['/home']);
  //   this.authService.login(this.form).pipe(
  //     switchMap(() => this.tokenStorageService.getCurrentUtilisateur())
  //   ).subscribe(
  //     userData => {
  //       this.currentUtilisateur = userData;
  //       //console.log(this.currentUtilisateur); CHECKED
  //       this.utilisateurService.getUserAccesses(this.currentUtilisateur.userId).subscribe(
  //         data => {
  //           let userAccesses: Access[] = data;
  //           for(const access of userAccesses){
  //             if (access.authority == "MANAGE_STAGIAIRES"){
  //               this.router.navigate(['/home/stagiaires']);
  //               break;
  //             }
  //             if (access.authority == "MANAGE_STAGES"){
  //               this.router.navigate(['/home/stages']);
  //               break;
  //             }
  //           }
  //         },
  //         error => {
  //           console.log(error);
  //         }
  //       );
  //     },
  //     error => {
  //       console.log(error);
  //       if (error.status === 403) {
  //         this.errorMessage = "Accès interdit. Veuillez vérifier vos informations d'identification.";
  //       }
  //       else {
  //         this.errorMessage = "Une erreur s'est produite lors de l'authentification.";
  //       }
  //     }
  //   );
  }
}
