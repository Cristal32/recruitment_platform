import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Candidacy } from 'src/app/models/candidacy';
import { CandidacyService } from 'src/app/services/candidacy.service';
import { GlobalService } from 'src/app/services/global.service';

@Component({
  selector: 'app-my-applications',
  templateUrl: './my-applications.component.html',
  styleUrls: ['./my-applications.component.css']
})
export class MyApplicationsComponent implements OnInit{
  listMyCandidacies: Candidacy[] = [];

  public constructor(private candidacyService: CandidacyService, private globalService: GlobalService){}

  ngOnInit(): void {
    this.getUserCandidacies(this.globalService.currentUtilisateur.id);
  }

  getUserCandidacies(offerId: number){
    return this.candidacyService.getCandidaciesByUser(offerId).subscribe(
      data => {
        console.log(data);
        for(const candidate of data){ this.listMyCandidacies.push(candidate); }
      },
      (error: HttpErrorResponse) => {
        console.log(error)
      }
    );
  }
}
