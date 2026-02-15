import { Component, inject } from '@angular/core';
import { ResponseCount as AnswersCount } from "../response-count/response-count";
import { QuestionContent } from "../question-content/question-content";
import { ResultService } from '../../services/result.service';

@Component({
  selector: 'app-question-container',
  imports: [AnswersCount, QuestionContent],
  templateUrl: './question-container.html',
  styleUrl: './question-container.css',
})
export class QuestionContainer {

  protected service = inject(ResultService);

  protected statement() : string {
    return this.service.currentStatement();
  }
}
