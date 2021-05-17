import { Survey } from "./survey";

export class Surveyor{
    id:number=0;
    firstName:string='';
    lastName:string='';
    username:string='';
    createdSurveys:Survey[]=[];
    constructor(id:number,firstName:string,lastName:string,username:string,createdSurvey:Survey[]){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.username=username;
        this.createdSurveys=createdSurvey;
    }
}