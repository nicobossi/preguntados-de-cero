import { Option } from "@/app/shared/types/option";
import { Question } from "@/app/shared/types/question";
import { QuestionResult } from "@/app/shared/types/question-result";
import { Injectable, signal } from "@angular/core";


@Injectable({
  providedIn: 'root'
})
export class ResultService {

  private resultGame = signal<QuestionResult[]>([]);

  registerTo(question : Question, selectedOption : Option, winningOption : Option) {

    this.resultGame.update(results => {
      results.push(this.questionResult(question, selectedOption, winningOption));
      return results;
    });
  }

  refresh() : void {
    this.resultGame.set([]);
  }

  private questionResult(question: Question, selectedOption: Option, winningOption: Option) : QuestionResult {
    return {
      textQuestion: question.text,
      selectedAnswer: selectedOption.text,
      winningAnswer: winningOption.text
    }
  }

  get getResultGame() : QuestionResult[] {
    return this.resultGame();
  }
}
