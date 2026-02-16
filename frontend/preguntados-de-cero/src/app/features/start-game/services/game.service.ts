import { Option } from "@/app/shared/types/option";
import { Question } from "@/app/shared/types/question";
import { inject, Injectable, signal } from "@angular/core";
import { CounterService } from "./counter.service";
import { ResultService } from "./result.service";


@Injectable()
export class GameService {
  private questions = signal<Question[]>([]);
  private resultService = inject(ResultService);
  private counterService = inject(CounterService);
  private index = 0;

  setQuestions(questions : Question[]) {
    this.questions.set(questions);
  }

  registerAnswer(option : Option) {
    this.resultService.registerTo(option);
    this.counterService.countTo(option);
  }

  currentStatement() : string {
    return this.currentQuestion().text;
  }

  currentOptions() : Option[] {
    return this.currentQuestion().options
  }

  goNextQuestion() : void {
    this.resultService.refresh();
    this.index++;
  }

  get isCorrectResult() : boolean | null {
    return this.resultService.isCorrectResult();
  }

  get getHaveAnsware() : boolean {
    return this.resultService.getHaveAnswer;
  }

  get getTotalAnswers() : number {
    return this.counterService.getTotal;
  }

  get getCorrectAnswers() : number {
    return this.counterService.getTotalCorrectAnswers;
  }

  get getCountQuestions() : number {
    return this.questions().length;
  }

  private currentQuestion() : Question {
    if(this.questions().length !== 0) return this.questions()[this.index];
    else throw new Error("error al cargar la pregunta"); //acá navega a la otra pagina
  }
}
