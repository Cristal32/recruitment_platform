import { User } from "./user";

export class Offer{
    id: number = 0;
    poster: User = new User();
    title: string = '';
    hqLocation: string = '';
    expYears: string = '';
    jobDesc: string = '';
    jobLocation: string = '';
    companyDesc: string = '';
    roleRespos: string = '';
    startDate: Date = new Date();
    postDate: Date = new Date();
    status: string = '';
}