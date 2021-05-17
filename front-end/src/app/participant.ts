import { Feedback } from "./feedback";

export class Participant{
    id:number=0;
    firstName:string='';
    lastName:string='';
    username:string='';
    feedbacks:Feedback[]=[];
    constructor(id:number,firstName:string,lastName:string,username:string,feedbacks:Feedback[]){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.username=username;
        this.feedbacks=feedbacks;
    }
}