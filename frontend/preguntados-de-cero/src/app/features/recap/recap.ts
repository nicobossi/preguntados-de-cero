import {Component} from '@angular/core';
import {
  AnswersButtonsContainer
} from '@/app/features/recap/components/answers-buttons-container/answers-buttons-container';

@Component({
  selector: 'app-recap',
  imports: [
    AnswersButtonsContainer
  ],
  templateUrl: './recap.html',
  styleUrl: './recap.css',
})
export class Recap {

}
