import { Survey } from "./survey";
import { Surveyor } from "./surveyor";

export class Topic{
    id:number=0;
    topictName:string='';
    topicDescription:string='';
    surveys:Survey[]=[];
    createdBy:Surveyor;
    constructor(id:number,topicName:string,topicDescription:string,surveys:Survey[],createdBy:Surveyor){
        this.id=id;
        this.topictName=topicName;
        this.topicDescription=topicDescription;
        this.surveys=surveys;
        this.createdBy=createdBy;
    }
}