import { Component, input } from '@angular/core';
import { LevelHeader } from '../level-header/level-header';
import { ThemeNamesContainer } from '../theme-names-container/theme-names-container';
import { LevelButton } from '../level-button/level-button';
import Difficulty from '@/app/shared/types/difficulty';
@Component({
  selector: 'app-level-card',
  imports: [LevelHeader, ThemeNamesContainer, LevelButton],
  templateUrl: './level-card.html',
  styleUrl: './level-card.css',
})
export class LevelCard {

  difficulty = input<Difficulty>();

  get getDifficulty() : Difficulty {
    return this.difficulty() as Difficulty;
  }
}
