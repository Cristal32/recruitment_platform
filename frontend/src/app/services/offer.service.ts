import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { Offer } from '../models/offer';

@Injectable({
  providedIn: 'root'
})
export class OfferService {
  private apiServerUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }

  public getAllOffers(): Observable<Offer[]>{
    return this.http.get<Offer[]>(`${this.apiServerUrl}/offer/getAll`);
  }

  public getOffersByPoster(posterId: number): Observable<Offer[]>{
    return this.http.get<Offer[]>(`${this.apiServerUrl}/offer/getPoster/${posterId}`);
  }

  public addOffer(offer: Offer): Observable<Offer>{
    return this.http.post<Offer>(`${this.apiServerUrl}/offer/add`, offer);
  }
  public updateOffer(offerr: Offer): Observable<Offer>{
      return this.http.put<Offer>(`${this.apiServerUrl}/offer/update`, offerr);
  }

  public deleteOffer(offerId: number): Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/offer/delete/${offerId}`);
  }
}
