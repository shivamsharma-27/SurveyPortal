import { Feedback } from "./feedback";
import { Topic } from "./topic";

export class Survey{
    id:number=0;
    description:string='';
    topic:Topic;
    publishedDate:Date;
    endDate:Date;
    active:boolean;
    feedbacks:Feedback[]=[];
    constructor(id:number,description:string,topic:Topic,publishedDate:Date,endDate:Date,active:boolean,feedbacks:Feedback[]){
        this.id=id;
        this.description=description;
        this.active=active;
        this.topic=topic;
        this.publishedDate=publishedDate;
        this.endDate=endDate;
        this.feedbacks=feedbacks;

    }
}