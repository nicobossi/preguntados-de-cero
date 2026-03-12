import {Component} from '@angular/core';
import {
  EndGameCardsButtonsContainer
} from '@/app/features/end-game/components/end-game-cards-buttons-container/end-game-cards-buttons-container';

@Component({
  selector: 'app-end-game',
  imports: [
    EndGameCardsButtonsContainer
  ],
  templateUrl: './end-game.html',
  styleUrl: './end-game.css',
})
export class EndGame {

}
