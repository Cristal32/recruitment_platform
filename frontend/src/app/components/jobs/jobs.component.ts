import { Component, OnInit } from '@angular/core';
import { Offer } from 'src/app/models/offer';
import { OfferService } from 'src/app/services/offer.service';

@Component({
  selector: 'app-jobs',
  templateUrl: './jobs.component.html',
  styleUrls: ['./jobs.component.css']
})
export class JobsComponent implements OnInit {
  listOffers: Offer[] = [];
  filteredListOffers: Offer[] = [];
  selectedOffer: Offer = new Offer();

  // Application form
  form: any = {
    cv: '',
    desc: ''
  };

  // Constructor
  constructor(
    private offerService: OfferService){}

  ngOnInit(): void {
    this.getAllOffers();
  }

  assignSelectedOffer(offer: Offer){
    this.selectedOffer = offer;
  }

  getAllOffers(){
    this.offerService.getAllOffers().subscribe(
      ((offers: any) => {
        this.listOffers = offers;
        this.filteredListOffers = [...this.listOffers];
    }));
  }

  ApplyForm(){

  }
}
