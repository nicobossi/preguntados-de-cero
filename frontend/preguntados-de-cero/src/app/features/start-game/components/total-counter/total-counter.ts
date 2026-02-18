import { Component, input } from '@angular/core';
import { GradientResultDirective } from "../../directives/gradient-result";

@Component({
  selector: 'app-total-counter',
  imports: [GradientResultDirective],
  templateUrl: './total-counter.html',
  styleUrl: './total-counter.css',
})
export class TotalCounter {

  totalAnswers = input<number>();
  totalQuestions = input<number>();
}
