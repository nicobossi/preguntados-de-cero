import { Component, inject, input } from '@angular/core';
import { CounterService } from '../../services/counter.service';

@Component({
  selector: 'app-question-content',
  imports: [],
  templateUrl: './question-content.html',
  styleUrl: './question-content.css',
})
export class QuestionContent {

  statment = input.required<string>();
}
