import { Component } from '@angular/core';
import {AnswersContainer} from '@/app/features/recap/components/answers-container/answers-container';
import {RecapButtonsContainer} from '@/app/features/recap/components/recap-buttons-container/recap-buttons-container';

@Component({
  selector: 'app-answers-buttons-container',
  imports: [
    AnswersContainer,
    RecapButtonsContainer
  ],
  templateUrl: './answers-buttons-container.html',
  styleUrl: './answers-buttons-container.css',
})
export class AnswersButtonsContainer {

}
