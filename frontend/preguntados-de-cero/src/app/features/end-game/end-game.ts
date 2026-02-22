import {Component} from '@angular/core';
import {AppHeader} from '@/app/shared/components/app-header/header';
import {
  EndGameCardsButtonsContainer
} from '@/app/features/end-game/components/end-game-cards-buttons-container/end-game-cards-buttons-container';

@Component({
  selector: 'app-end-game',
  imports: [
    AppHeader,
    EndGameCardsButtonsContainer
  ],
  templateUrl: './end-game.html',
  styleUrl: './end-game.css',
})
export class EndGame {

}
