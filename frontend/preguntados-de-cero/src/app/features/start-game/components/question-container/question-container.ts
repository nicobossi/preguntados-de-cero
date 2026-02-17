import { Component, inject } from '@angular/core';
import { ResponseCount as AnswersCount } from "../response-count/response-count";
import { QuestionContent } from "../question-content/question-content";
import { GameService } from '../../services/game.service';

@Component({
  selector: 'app-question-container',
  imports: [AnswersCount, QuestionContent],
  templateUrl: './question-container.html',
  styleUrl: './question-container.css',
})
export class QuestionContainer {

  protected service = inject(GameService);

  protected statement() : string {
    return this.service.currentStatement();
  }
}
