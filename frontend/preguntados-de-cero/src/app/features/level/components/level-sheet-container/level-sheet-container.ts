import { Component, inject } from '@angular/core';
import { LevelSheet  } from '../level-sheet/level-sheet';
import Difficulty from '@/app/shared/types/difficulty';
import { LevelSelectorService } from '../../services/level-selector/level-selector.service';

@Component({
  selector: 'app-sheet-container',
  imports: [LevelSheet],
  templateUrl: './level-sheet-container.html',
  styleUrl: './level-sheet-container.css',
})
export class LevelSheetContainer {

  protected service = inject(LevelSelectorService);

  get getDifficulty() : Difficulty {
    return this.service.currentLevel();
  }

  get getIsChange() : boolean {
    return this.service.isInitChange();
  }

  onOffChange() : void {
    this.service.finishChange();
  }
}
