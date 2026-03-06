import { Component, inject } from '@angular/core';
import { LevelSheetContainer } from './components/level-sheet-container/level-sheet-container';
import LevelService from './services/level/level.service';
import { LevelSelectorService } from './services/level-selector/level-selector.service';
import { StateLoader } from '@/app/shared/components/state-loader/state-loader';

@Component({
  selector: 'app-level',
  imports: [LevelSheetContainer, StateLoader],
  providers: [LevelService, LevelSelectorService],
  templateUrl: './level.html',
  styleUrl: './level.css'
})
export class Level {

  protected services = inject(LevelService);

  ngOnInit() : void {
    this.services.getAll();
  }
}
