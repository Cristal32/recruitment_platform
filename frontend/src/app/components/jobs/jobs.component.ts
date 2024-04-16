import { HttpErrorResponse } from '@angular/common/http';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Candidacy } from 'src/app/models/candidacy';
import { FileData } from 'src/app/models/fileData';
import { Offer } from 'src/app/models/offer';
import { CandidacyService } from 'src/app/services/candidacy.service';
import { FileService } from 'src/app/services/file.service';
import { GlobalService } from 'src/app/services/global.service';
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
  createdCandidacy: Candidacy = new Candidacy();

  currentUser = this.globalService.currentUtilisateur;

  // Application form
  form: any = {
    cv: null,
    desc: ''
  };

  // Constructor
  constructor(private offerService: OfferService, private fileService: FileService, private candidacyService: CandidacyService, 
    private globalService: GlobalService){}

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

  //============================================== file system ==============================================
   //initialise a file
   fileContent: BlobPart[] = [""];
   fileName = "";
   selectedCv: File = new File(this.fileContent, this.fileName);
   editedCandidacyCv: File = new File(this.fileContent, this.fileName);

  getFileByFileName(filename: string){
    this.fileService.getFileByFileName(filename).subscribe(
      data => {
        console.log(data);

      },
      (error: HttpErrorResponse) => {
        console.log(error)
      }
    );
  }

  onCreateCvSelected(event: any) {
    this.selectedCv = event.target.files[0];
  }

  @ViewChild('createCvInput') createCvInput!: ElementRef;
  resetSelectedCv(){
    this.selectedCv = new File(this.fileContent, this.fileName);
    if(this.createCvInput.nativeElement.value){
      this.createCvInput.nativeElement.value = null;
    }
    
  }

  ApplyForm(){
    this.createdCandidacy.offer = this.selectedOffer;
    this.createdCandidacy.user = this.currentUser;
    this.createdCandidacy.id.offerId = this.selectedOffer.id;
    this.createdCandidacy.id.userId = this.currentUser.id;
    console.log(this.selectedCv);
    this.candidacyService.addCandidacyWithCv(this.createdCandidacy, this.selectedCv).subscribe(
      data => {
        console.log(data);
        window.location.reload();
      },
      error => console.log(error)
    );
  }

}
