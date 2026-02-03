import { Component, inject } from '@angular/core';
import { LevelCard } from '../level-card/level-card';
import { LevelService } from '../../services/level/level.service';
import Difficulty from '@/app/shared/types/difficulty';

@Component({
  selector: 'app-buttons-container',
  imports: [LevelCard],
  templateUrl: './level-card-container.html',
  styleUrl: './level-card-container.css',
})
export class LevelCardContainer {

  protected service = inject(LevelService);

  get getDifficulties() : Difficulty[] {
    return this.service.getDifficulties;
  }
}
