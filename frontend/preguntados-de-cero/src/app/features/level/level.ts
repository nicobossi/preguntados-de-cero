import { Component, inject, OnInit } from '@angular/core';
import { AppHeader } from '@/app/shared/components/app-header/header';
import { ButtonsContainer } from './components/buttons-container/buttons-container';
import { LevelService } from './services/level/level.service';
import Difficulty from '@/app/shared/types/difficulty';

@Component({
  selector: 'app-level',
  imports: [AppHeader, ButtonsContainer],
  providers: [LevelService],
  templateUrl: './level.html',
  styleUrl: './level.css'
})
export class Level {

  private services = inject(LevelService);

  ngOnInit() : void {
    this.services.getAll();
  }

  get difficulties() : Difficulty[] {
    return this.services.getDifficulties;
  }
}
