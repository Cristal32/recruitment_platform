import { Injectable } from '@angular/core';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class GlobalService {
  public apiServerUrl = 'http://localhost:8080/api';

  currentUtilisateur: User = 
  {
    id: 1,
    email: 'mery@gmail.com',
    pwd: 'mery32',
    name: 'Meryem',
    lastName: 'El Karati'
  };
//   {
//     "id": 2,
//     "email": "safae@gmail.com",
//     "pwd": "safae23",
//     "name": "Safae",
//     "lastName": "el hassani"
// };
//   {
//     "id": 3,
//     "email": "elasri@um5.ac.ma",
//     "pwd": "elasri32",
//     "name": "Bouchra",
//     "lastName": "El Asri"
// };
// {
//   "id": 4,
//   "email": "hamlaoui@gmail.com",
//   "pwd": "hamlaoui32",
//   "name": "Mohammed",
//   "lastName": "Hamlaoui"
// };
  constructor() { }
}
