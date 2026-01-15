import { Component, inject, Input, OnInit, signal } from '@angular/core';
import { LevelButton } from '../level-button/level-button';
import Difficulty from '@/app/shared/types/difficulty';
import { LevelService } from '../../services/level/level.service';

@Component({
  selector: 'app-buttons-container',
  imports: [LevelButton],
  providers: [LevelService],
  templateUrl: './buttons-container.html',
  styleUrl: './buttons-container.css',
})
export class ButtonsContainer {

  private services = inject(LevelService);

  get difficulties() {
    return this.services.getDifficulties
  }
}
