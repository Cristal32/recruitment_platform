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
  jobs: Offer[] = [
    {
      "id": 1,
      "employer": "PAYME",
      "poster":
      {
        "id": 1,
        "email": "",
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
        "email": "",
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

  // Constructor
  constructor(
    private offerService: OfferService){}

  ngOnInit(): void {
    this.getAllOffers();
  }

  getAllOffers(){
    this.offerService.getAllOffers().subscribe(
      ((offers: any) => {
        this.listOffers = offers;
        this.filteredListOffers = [...this.listOffers];
    }));
  }
}