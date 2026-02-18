import {Component, inject} from '@angular/core';
import {CounterService} from '@/app/core/services/counter-game/counter.service';
import {PlayerName} from '@/app/core/services/player-name/player-name';
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
  private counterService = inject(CounterService);
  private nameService = inject(PlayerName)

  ngOnInit(){ // esto es solo para debug, borrar despues
    console.log("Jugador: " + this.nameService.getName);
    console.log("preguntas totales: " + this.counterService.getTotal);
    console.log("preguntas bien respondidas: " + this.counterService.getTotalCorrectAnswers);
    console.log("preguntas mal respondidas: " + this.counterService.getTotalIncorrectAnswers());
  }

  private getPlayerName(): string {
    return this.nameService.getName;
  }

  congratulations() : string {
    return "¡Felicitaciones, " + this.getPlayerName() + "!";
  }
}
