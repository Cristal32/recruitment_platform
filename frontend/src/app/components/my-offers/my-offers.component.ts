import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Candidacy } from 'src/app/models/candidacy';
import { Offer } from 'src/app/models/offer';
import { User } from 'src/app/models/user';
import { CandidacyService } from 'src/app/services/candidacy.service';
import { OfferService } from 'src/app/services/offer.service';

@Component({
  selector: 'app-my-offers',
  templateUrl: './my-offers.component.html',
  styleUrls: ['./my-offers.component.css']
})
export class MyOffersComponent implements OnInit{

  //managed offer variables
  createdOffer: Offer = new Offer();
  selectedOffer: Offer = new Offer();
  selectedCandidates: Candidacy[] = []

  currentUser: User = {
    "id": 2,
    "email": "safae@dxc.com",
    "pwd": "safae23",
    "name": "Safae",
    "lastName": "Ibrahimi"
  };
  listMyOffers: Offer[] = [];
  filteredListMyOffers: Offer[] = [];
  candidates: Candidacy[] = [];
 
  // Create offer form
  form: any = {
    employer: '',
    poster: null,
    jobTitle: '',
    companyHq: '',
    wage: '',
    expYears: '',
    jobDesc: '',
    jobLocation: '',
    companyDesc: '',
    roleRespos: '',
    roleReqs: '',
    startDate: null,
    postDate: null
  };

  // Constructor
  constructor(private offerService: OfferService, private candidacyService: CandidacyService){}

  ngOnInit(){
    this.getAllMyOffers(this.currentUser.id);
  }

  //puts the value of the create offer form in the createdPffer variable
  setFormInCreatedOffer() {
    this.createdOffer.employer = this.form.employer;
    this.createdOffer.poster = this.form.poster;
    this.createdOffer.title = this.form.jobTitle;
    this.createdOffer.hqLocation = this.form.companyHq;
    this.createdOffer.expYears = this.form.expYears;
    this.createdOffer.jobDesc = this.form.jobDesc;
    this.createdOffer.jobLocation = this.form.jobLocation;
    this.createdOffer.companyDesc = this.form.companyDesc;
    this.createdOffer.roleRespos = this.form.roleRespos;
    this.createdOffer.startDate = this.form.startDate;
    this.createdOffer.postDate = this.form.postDate;
  }

  // ============================================== tabs management ==============================================
  tabBackgroundColor: string = '#f1f1f1';
  createOfferModal_ActiveTab: string = 'jobInfoTab';

  setActiveCreateTab(tab: string){
    this.createOfferModal_ActiveTab = tab;
  }
  
  // ============================================== Assign variables ==============================================
  assignSelectedOffer(offer: Offer){
    this.selectedOffer = offer;
    this.getOfferCandidates(offer.id);
  }

  assignCreatedOffer(offer: Offer){
    this.createdOffer = offer;
  }
  // -----------------------------------------------------------------------

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

  getOfferCandidates(offerId: number){
    return this.candidacyService.getCandidaciesByOffer(offerId).subscribe(
      data => {
        console.log(data);
        for(const candidate of data){ this.selectedCandidates.push(candidate); }
      },
      (error: HttpErrorResponse) => {
        console.log(error)
      }
    );
  }

  clearCandidates(){
    this.selectedCandidates = [];
  }

  //============================================== create offer ==============================================
  createOfferForm(){
    // Put in the filled in form data
    this.setFormInCreatedOffer();

    //Set poster
    this.createdOffer.poster = this.currentUser;

    // console.log(this.createdOffer);
    this.offerService.addOffer(this.createdOffer).subscribe(
      data => {
        // console.log(data);
        window.location.reload();
      },
      error => console.log(error)
    );
  }
}
