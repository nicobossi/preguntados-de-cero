import { Component, inject } from '@angular/core';
import { LevelSheet  } from '../level-sheet/level-sheet';
import Difficulty from '@/app/shared/types/difficulty';
import { LevelSelectorService } from '../../services/level-selector/level-selector.service';

@Component({
  selector: 'app-cards-container',
  imports: [LevelSheet],
  templateUrl: './level-card-container.html',
  styleUrl: './level-card-container.css',
})
export class LevelCardContainer {

  protected service = inject(LevelSelectorService);

  get getDifficulty() : Difficulty {
    return this.service.currentLevel();
  }
}
