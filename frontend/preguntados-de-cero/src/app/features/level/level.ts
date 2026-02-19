import { Component, inject } from '@angular/core';
import { AppHeader } from '@/app/shared/components/app-header/header';
import { LevelCardContainer } from './components/level-card-container/level-card-container';
import { LevelService } from './services/level/level.service';
import { LevelSelectorService } from './services/level-selector/level-selector.service';

@Component({
  selector: 'app-level',
  imports: [AppHeader, LevelCardContainer],
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
