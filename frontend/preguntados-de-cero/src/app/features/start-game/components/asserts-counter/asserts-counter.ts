import { Component, input } from '@angular/core';
import { GradientResultDirective } from "../../directives/gradient-result";

@Component({
  selector: 'app-asserts-counter',
  imports: [GradientResultDirective],
  templateUrl: './asserts-counter.html',
  styleUrl: './asserts-counter.css',
})
export class AssertsCounter {

  totalCorrectAnswers = input<number>();
  totalQuestions = input<number>();
}
