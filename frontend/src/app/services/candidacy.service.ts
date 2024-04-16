import { Injectable } from '@angular/core';
import { Candidacy } from '../models/candidacy';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { GlobalService } from './global.service';

@Injectable({
  providedIn: 'root'
})
export class CandidacyService {

  constructor(private http: HttpClient, private globalService: GlobalService) { }

  private apiServerUrl = this.globalService.apiServerUrl;

  public getAllCandidacies(): Observable<Candidacy[]>{
    return this.http.get<Candidacy[]>(`${this.apiServerUrl}/candidacy/getAll`);
  }

  public getCandidaciesByOffer(offerId: number): Observable<Candidacy[]>{
    return this.http.get<Candidacy[]>(`${this.apiServerUrl}/candidacy/getByOffer/${offerId}`);
  }

  public getCandidaciesByUser(userId: number): Observable<Candidacy[]>{
    return this.http.get<Candidacy[]>(`${this.apiServerUrl}/candidacy/getByUser/${userId}`);
  }

  public addCandidacy(candidate: Candidacy): Observable<Candidacy>{
    return this.http.post<Candidacy>(`${this.apiServerUrl}/candidacy/add`, candidate);
  }

  public addCandidacyWithCv(candidate: Candidacy, cvFile: File): Observable<any>{
    const formData = new FormData();
    formData.append('file', cvFile);

    console.log(formData);
    console.log(cvFile.name);

    const stagiaireJson = JSON.stringify(candidate);
    formData.append('candidateData', new Blob([stagiaireJson], { type: 'application/json' }));

    return this.http.request('post', `${this.apiServerUrl}/candidacy/addWithCv`, {
      body: formData,
      responseType: 'text'
    });
  }

  public updateCandidacy(offer: Candidacy): Observable<Candidacy>{
      return this.http.put<Candidacy>(`${this.apiServerUrl}/candidacy/update`, offer);
  }

  public deleteCandidacy(offerId: number): Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/candidacy/delete/${offerId}`);
  }

  public validateCandidacy(offerId: number, userId: number): Observable<any>{
    return this.http.put(`${this.apiServerUrl}/candidacy/validate/${offerId}/${userId}`,{});
  }

  public rejectCandidacy(offerId: number, userId: number): Observable<any> {
    return this.http.put(`${this.apiServerUrl}/candidacy/reject/${offerId}/${userId}`,{});
  }
}
