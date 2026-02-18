import { Component, input } from '@angular/core';
import { GradientResultDirective } from "../../directives/gradient-result";

@Component({
  selector: 'app-question-content',
  imports: [GradientResultDirective],
  templateUrl: './question-content.html',
  styleUrl: './question-content.css',
})
export class QuestionContent {

  statment = input.required<string>();
}
