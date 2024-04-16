import { CvFile } from "./cvFile";
import { Offer } from "./offer";
import { User } from "./user";

export class Candidacy{
    id: number = 0;
    user: User = new User();
    offer: Offer = new Offer();
    desc: string = '';
    cv: CvFile = new CvFile();
    status: number = 0;
}