import {Component, inject} from '@angular/core';
import {PlayAgainButton} from '@/app/features/end-game/components/play-again-button/play-again-button';
import {RecapButton} from '@/app/features/end-game/components/recap-button/recap-button';
import {NavegateService} from '@/app/core/services/navegate/navegate.services';

@Component({
  selector: 'app-end-game-buttons-container',
  imports: [
    PlayAgainButton,
    RecapButton
  ],
  templateUrl: './end-game-buttons-container.html',
  styleUrl: './end-game-buttons-container.css',
})
export class EndGameButtonsContainer {
  navegateService = inject(NavegateService);

  navegateToLevel() {
    this.navegateService.goLevel();
  }

  navegateToRecap() {
    this.navegateService.goRecap();
  }
}
