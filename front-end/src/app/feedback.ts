import { Option } from "./option";
import { Participant } from "./participant";
import { Survey } from "./survey";

export class Feedback{
    id:number=0;
    survey:Survey;
    participant:Participant;
    postedDate:Date;
    chosenAnswers:Map<number,Option>;
    constructor(id:number,survey:Survey,participant:Participant,postedDate:Date, chosenAnswers:Map<number,Option>){
        this.id=id;
        this.survey=survey;
        this.participant=participant;
        this.postedDate=postedDate;
        this.chosenAnswers=chosenAnswers;
    }
}