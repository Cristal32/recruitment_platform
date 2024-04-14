import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Candidacy } from 'src/app/models/candidacy';
import { Offer } from 'src/app/models/offer';
import { OfferService } from 'src/app/services/offer.service';

@Component({
  selector: 'app-my-offers',
  templateUrl: './my-offers.component.html',
  styleUrls: ['./my-offers.component.css']
})
export class MyOffersComponent implements OnInit{
  listMyOffers: Offer[] = [];
  filteredListMyOffers: Offer[] = [];
  showCandidatesMap: { [key: number]: boolean } = {};
  candidates: Candidacy[] = [];
  selectedOffer: Offer = new Offer();
  offers: Offer[] = [
    {
      "id": 1,
      "employer": "PAYME",
      "poster":
      {
        "id": 1,
        "email": "mery@gmail.com",
        "pwd": "",
        "name": "meryem",
        "lastName": "EL KARATI"
      },
      "title": "Software Engineer",
      "companyDesc": "company desc",
      "expYears": "2-3 years",
      "hqLocation": "Rabat",
      "jobLocation": "Rabat",
      "jobDesc": "job desc",
      "postDate": new Date(2023, 6, 3),
      "roleRespos": "SUpervisor",
      "startDate": new Date(2023, 6, 4),
      "status": "OPEN"
    },
    {
      "id": 2,
      "employer": "DXC Technology",
      "poster":
      {
        "id": 1,
        "email": "karati@gmail.com",
        "pwd": "",
        "name": "meryem",
        "lastName": "EL KARATI"
      },
      "title": "Software Engineer",
      "companyDesc": "company desc",
      "expYears": "2-3 years",
      "hqLocation": "Rabat",
      "jobLocation": "Rabat",
      "jobDesc": "job desc",
      "postDate": new Date(2023, 6, 3),
      "roleRespos": "SUpervisor",
      "startDate": new Date(2023, 6, 4),
      "status": "OPEN"
    }
  ];

  my_offers = this.offers.filter(offer => offer.poster.email === "mery@gmail.com");

  // Constructor
  constructor(
    private offerService: OfferService){}

  ngOnInit(){
    // Initialize all offers having their corresponding showCandidate false, so the candidates table doesn't appear
    this.my_offers.forEach(offer => {
      this.showCandidatesMap[offer.id] = false;
    });
  }

  toggleCandidates(job: Offer){
    // For a specific offer, make its candidates table visible or invisible
    this.showCandidatesMap[job.id] = !this.showCandidatesMap[job.id];
  }

  areCandidatesShown(offerId: number): boolean {
    return this.showCandidatesMap[offerId];
  }
  
  assignSelectedOffer(offer: Offer){
    this.selectedOffer = offer;
  }

  getAllMyOffers(userId: number){
    return this.offerService.getOffersByPoster(userId).subscribe(
      data => {
        //console.log(data);
        for(const offer of data){ this.listMyOffers.push(offer); }
        this.filteredListMyOffers = [...this.listMyOffers];
      },
      (error: HttpErrorResponse) => {
        console.log(error)
      }
    );
  }
}
