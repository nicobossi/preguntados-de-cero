import { Option } from "@/app/shared/types/option";
import { Question } from "@/app/shared/types/question";
import { inject, Injectable, Signal, signal } from "@angular/core";
import { CounterService } from "../../../core/services/counter-game/counter.service";
import { OptionService } from "./option.service";
import { ResultService } from "@/app/core/services/result-game/result.service";


@Injectable()
export class GameService {
  private questions = signal<Question[]>([]);
  private optionService = inject(OptionService);
  private counterService = inject(CounterService);
  private resultService = inject(ResultService);
  private index = 0;

  setQuestions(questions : Question[]) {
    this.questions.set(questions);
    this.resultService.refresh();
  }

  registerAnswer(option : Option) {
    this.optionService.validateTo(option);
    this.resultService.registerTo(this.currentQuestion(), option, this.currentWinningOption());
    this.counterService.countTo(option);
  }

  currentStatement() : string {
    return this.currentQuestion().text;
  }

  currentOptions() : Option[] {
    return this.currentQuestion().options
  }

  goNextQuestion() : void {
    this.optionService.refresh();
    this.index++;
  }

  get isCorrectResult() : boolean | null {
    return this.optionService.isCorrectOption();
  }

  get isCorrectResultSignal() : Signal<boolean> {
    return this.optionService.isCorrectResultSignal();
  }

  get getHaveAnsware() : boolean {
    return this.optionService.getHaveAnswer;
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
    if(this.questions().length > this.index) return this.questions()[this.index];
    else throw new Error("error al cargar la pregunta");
  }

  private currentWinningOption() : Option {
    return this.currentQuestion().options.find(option => option.isCorrect) as Option;
  }
}
