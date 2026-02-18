import { Component } from '@angular/core';
import {
  EndGameCardsContainer
} from '@/app/features/end-game/components/end-game-cards-container/end-game-cards-container';
import {
  EndGameButtonsContainer
} from '@/app/features/end-game/components/end-game-buttons-container/end-game-buttons-container';

@Component({
  selector: 'app-end-game-cards-buttons-container',
  imports: [
    EndGameCardsContainer,
    EndGameButtonsContainer
  ],
  templateUrl: './end-game-cards-buttons-container.html',
  styleUrl: './end-game-cards-buttons-container.css',
})
export class EndGameCardsButtonsContainer {

}
