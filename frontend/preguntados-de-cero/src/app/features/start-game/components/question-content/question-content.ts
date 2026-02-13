import { Component, input } from '@angular/core';

@Component({
  selector: 'app-question-content',
  imports: [],
  templateUrl: './question-content.html',
  styleUrl: './question-content.css',
})
export class QuestionContent {

  statment = input.required<string>()
}
