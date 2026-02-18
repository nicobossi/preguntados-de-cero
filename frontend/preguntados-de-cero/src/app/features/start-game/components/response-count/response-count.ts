import { Component, inject } from '@angular/core';
import { GameService } from '../../services/game.service';
import { GradientResultDirective } from "../../directives/gradient-result";
import { TotalCounter } from "../total-counter/total-counter";
import { AssertsCounter } from "../asserts-counter/asserts-counter";

@Component({
  selector: 'app-response-count',
  templateUrl: './response-count.html',
  styleUrl: './response-count.css',
  imports: [TotalCounter, AssertsCounter],
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
