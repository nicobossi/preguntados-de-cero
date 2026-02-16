import { Component, inject } from '@angular/core';
import { GameService } from '../../services/game.service';

@Component({
  selector: 'app-response-count',
  templateUrl: './response-count.html',
  styleUrl: './response-count.css',
})
export class ResponseCount {

  service = inject(GameService);

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
