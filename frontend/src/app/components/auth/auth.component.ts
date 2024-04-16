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
  }
}
