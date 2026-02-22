import {Component, input} from '@angular/core';

@Component({
  selector: 'app-end-game-correct-card',
  imports: [],
  templateUrl: './end-game-correct-card.html',
  styleUrl: './end-game-correct-card.css',
})
export class EndGameCorrectCard {
  correctAnswers = input<string>();
}
