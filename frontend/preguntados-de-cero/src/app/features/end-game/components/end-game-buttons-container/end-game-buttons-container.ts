import {Component, inject} from '@angular/core';
import {NavegateService} from '@/app/core/services/navegate/navegate.services';
import { ButtonNavegate } from '../button-navegate/button-navegate';

@Component({
  selector: 'app-end-game-buttons-container',
  imports: [ButtonNavegate],
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
