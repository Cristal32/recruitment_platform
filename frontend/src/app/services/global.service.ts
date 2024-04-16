import { Injectable } from '@angular/core';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class GlobalService {
  currentUtilisateur: User = 
  // {
  //   id: 1,
  //   email: 'mery@gmail.com',
  //   pwd: 'mery32',
  //   name: 'Meryem',
  //   lastName: 'El Karati'
  // };
  {
    "id": 3,
    "email": "elasri@um5.ac.ma",
    "pwd": "elasri32",
    "name": "Bouchra",
    "lastName": "El Asri"
};
  constructor() { }
}
