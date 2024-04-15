import { Injectable } from '@angular/core';
import { Candidacy } from '../models/candidacy';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CandidacyService {

  private apiServerUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }

  public getAllCandidacies(): Observable<Candidacy[]>{
    return this.http.get<Candidacy[]>(`${this.apiServerUrl}/candidacy/getAll`);
  }

  public getCandidaciesByOffer(offerId: number): Observable<Candidacy[]>{
    return this.http.get<Candidacy[]>(`${this.apiServerUrl}/candidacy/getByOffer/${offerId}`);
  }

  public addCandidacy(offer: Candidacy): Observable<Candidacy>{
    return this.http.post<Candidacy>(`${this.apiServerUrl}/candidacy/add`, offer);
  }
  public updateCandidacy(offer: Candidacy): Observable<Candidacy>{
      return this.http.put<Candidacy>(`${this.apiServerUrl}/candidacy/update`, offer);
  }

  public deleteCandidacy(offerId: number): Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/candidacy/delete/${offerId}`);
  }
}
