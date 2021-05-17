import { Option } from "./option";
import { Survey } from "./survey";

export class Question{
    id:number;
    questionText:string;
    survey:Survey;
    options:Option[]=[];
    constructor(id:number,questionText:string,survey:Survey,options:Option[]){
        this.id=id;
        this.options=options;
        this.questionText=questionText;
        this.survey=survey;
    }
}