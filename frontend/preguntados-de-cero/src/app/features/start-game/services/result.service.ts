import { Option } from "@/app/shared/types/option";
import { Question } from "@/app/shared/types/question";
import { inject, Injectable, signal } from "@angular/core";
import { CounterService } from "./counter.service";


@Injectable({
  providedIn: 'root'
})
export class ResultService {
  private questions = signal<Question[]>([]);
  private haveAnswer = signal<boolean>(false);
  private questionsCounter = inject(CounterService);
  private index = 0;

  setQuestions(questions : Question[]) {
    this.questions.set(questions);
  }

  registerAnswer(option : Option) {
    this.haveAnswer.set(true);
    this.questionsCounter.countTo(option);
  }

  currentStatement() : string {
    return this.currentQuestion().text;
  }

  currentOptions() : Option[] {
    return this.currentQuestion().options
  }

  goNextQuestion() : void {
    this.haveAnswer.set(false);
    this.index++;
  }

  get getHaveAnsware() : boolean {
    return this.haveAnswer();
  }

  get getTotalAnswers() : number {
    return this.questionsCounter.getTotal;
  }

  get getCorrectAnswers() : number {
    return this.questionsCounter.getTotalCorrectAnswers;
  }

  get getCountQuestions() : number {
    return this.questions().length;
  }

  private currentQuestion() : Question {
    if(this.questions().length !== 0) return this.questions()[this.index];
    else throw new Error("error al cargar la pregunta"); //acá navega a la otra pagina
  }
}
