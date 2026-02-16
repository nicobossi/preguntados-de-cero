import { Option } from "@/app/shared/types/option";
import { Injectable, signal } from "@angular/core";



@Injectable()
export class ResultService {

  private haveAnswer = signal<boolean>(false);
  private isCorrectAnswer = signal<boolean | null>(null);

  registerTo(option : Option) : void {
    this.haveAnswer.set(true);
    this.isCorrectAnswer.set(option.isCorrect);
  }

  isCorrectResult(): boolean | null {
    return this.haveAnswer() && this.isCorrectAnswer()
  }

  get getHaveAnswer() : boolean {
    return this.haveAnswer()
  }

  refresh() {
    this.haveAnswer.set(false);
    this.isCorrectAnswer.set(null);
  }
}
