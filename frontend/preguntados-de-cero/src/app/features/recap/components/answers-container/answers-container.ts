import {Component, inject} from '@angular/core';
import {ResultService} from '@/app/core/services/result-game/result.service';
import {QuestionResult} from '@/app/shared/types/question-result';
import {AnswerCard} from '@/app/features/recap/components/answer-card/answer-card';

@Component({
  selector: 'app-answers-container',
  imports: [
    AnswerCard
  ],
  templateUrl: './answers-container.html',
  styleUrl: './answers-container.css',
})
export class AnswersContainer {
  private resultService = inject(ResultService)

  getGameResults() : QuestionResult[] {
    return this.resultService.getResultGame;
  }
}
