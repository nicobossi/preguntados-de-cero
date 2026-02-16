import { Option } from "@/app/shared/types/option";
import { Injectable, signal } from "@angular/core";



@Injectable()
export class OptionService {

  private haveAnswer = signal<boolean>(false);
  private correctOption = signal<boolean | null>(null);

  validateTo(option : Option) : void {
    this.haveAnswer.set(true);
    this.correctOption.set(option.isCorrect);
  }

  isCorrectOption(): boolean | null {
    return this.haveAnswer() && this.correctOption()
  }

  get getHaveAnswer() : boolean {
    return this.haveAnswer()
  }

  refresh() {
    this.haveAnswer.set(false);
    this.correctOption.set(null);
  }
}
