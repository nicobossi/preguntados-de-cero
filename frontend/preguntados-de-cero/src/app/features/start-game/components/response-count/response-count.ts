import { Component, inject } from '@angular/core';
import { ResultService } from '../../services/result.service';

@Component({
  selector: 'app-response-count',
  templateUrl: './response-count.html',
  styleUrl: './response-count.css',
})
export class ResponseCount {

  service = inject(ResultService);

  protected totalAnswers() : number {
    return this.service.getTotalAnswers;
  }

  protected totalQuestions() : number {
    return this.service.getCountQuestions;
  }

  protected totalCorrectAnswers() : number {
    return this.service.getCorrectAnswers;
  }
}
