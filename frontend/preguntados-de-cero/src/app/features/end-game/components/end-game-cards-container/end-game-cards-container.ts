import {Component, inject} from '@angular/core';
import {EndGameCorrectCard} from '@/app/features/end-game/components/end-game-correct-card/end-game-correct-card';
import {EndGameIncorrectCard} from '@/app/features/end-game/components/end-game-incorrect-card/end-game-incorrect-card';
import {CounterService} from '@/app/core/services/counter-game/counter.service';

@Component({
  selector: 'app-end-game-cards-container',
  imports: [
    EndGameCorrectCard,
    EndGameIncorrectCard
  ],
  templateUrl: './end-game-cards-container.html',
  styleUrl: './end-game-cards-container.css',
})
export class EndGameCardsContainer {
  private counterService = inject(CounterService);

  getTotalCorrectAnswers() : string {
    return this.counterService.getTotalCorrectAnswers + "/" + this.counterService.getTotal;
  }

  getTotalIncorrectAnswers() : string {
    return this.counterService.getTotalIncorrectAnswers() + "/" + this.counterService.getTotal;
  }
}
