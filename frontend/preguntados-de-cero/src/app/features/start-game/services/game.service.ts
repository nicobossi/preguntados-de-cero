import { Option } from "@/app/shared/types/option";
import { Question } from "@/app/shared/types/question";
import { inject, Injectable, signal } from "@angular/core";
import { CounterService } from "./counter.service";


@Injectable({
  providedIn: 'root'
})
export class GameService {
  private questions = signal<Question[]>([]);
  private haveAnswer = signal<boolean>(false);
  private isCorrectAnswer = signal<boolean | null>(null);
  private questionsCounter = inject(CounterService);
  private index = 0;

  setQuestions(questions : Question[]) {
    this.haveAnswer.set(false);
    this.isCorrectAnswer.set(null);
    this.questionsCounter.init();
    this.questions.set(questions);
    this.index = 0;
  }

  registerAnswer(option : Option) {
    this.haveAnswer.set(true);
    this.isCorrectAnswer.set(option.isCorrect);
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
    this.isCorrectAnswer.set(null);
    this.index++;
  }

  get isCorrectResult() : boolean | null {
    return this.haveAnswer() && this.isCorrectAnswer();
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
