import {Component, input} from '@angular/core';
import {QuestionResult} from '@/app/shared/types/question-result';

@Component({
  selector: 'app-answer-card',
  imports: [],
  templateUrl: './answer-card.html',
  styleUrl: './answer-card.css',
})
export class AnswerCard {
  answer = input.required<QuestionResult>();
  order = input.required<number>();

  getQuestionText() : string {
    return this.answer().textQuestion;
  }

  getSelectedAnswer() : string {
    return this.answer().selectedAnswer;
  }

  getWinningAnswer() : string {
    return this.answer().winningAnswer;
  }

  getOrder() : number {
    return this.order();
  }

  isCorrect() : boolean {
    return this.getSelectedAnswer() == this.getWinningAnswer();
  }
}
