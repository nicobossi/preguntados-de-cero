import { Option } from "@/app/shared/types/option";
import { Injectable, signal } from "@angular/core";


@Injectable({
  providedIn: 'root'
})
export class CounterService {
  private totalAnswers = signal<number>(0);
  private totalCorrectAnswers = signal<number>(0);

  init() : void {
    this.totalAnswers.set(0);
    this.totalCorrectAnswers.set(0);
  }

  countTo(option : Option) {
    if(option.isCorrect) this.totalCorrectAnswers.update(count => count + 1);
    this.totalAnswers.update(count => count + 1);
  }

  get getTotal() : number {
    return this.totalAnswers();
  }

  get getTotalCorrectAnswers() : number {
    return this.totalCorrectAnswers();
  }
}
