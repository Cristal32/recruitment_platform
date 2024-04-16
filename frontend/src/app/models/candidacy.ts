import { FileData } from "./fileData";
import { Offer } from "./offer";
import { User } from "./user";

export class Candidacy{
    id: CandidacyId = new CandidacyId();
    user: User = new User();
    offer: Offer = new Offer();
    desc: string = '';
    cv: FileData = new FileData();
    status: number = 0;
}

export class CandidacyId {
    userId: number = 0;
    offerId: number = 0;
}

