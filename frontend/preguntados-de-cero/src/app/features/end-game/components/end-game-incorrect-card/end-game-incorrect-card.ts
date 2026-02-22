import {Component, input} from '@angular/core';

@Component({
  selector: 'app-end-game-incorrect-card',
  imports: [],
  templateUrl: './end-game-incorrect-card.html',
  styleUrl: './end-game-incorrect-card.css',
})
export class EndGameIncorrectCard {
  incorrectAnswers = input<string>();
}
