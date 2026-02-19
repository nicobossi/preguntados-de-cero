import { Component, inject, input } from '@angular/core';
import { LevelHeader } from '../level-header/level-header';
import { ThemeNamesContainer } from '../theme-names-container/theme-names-container';
import { LevelButton } from '../level-button/level-button';
import Difficulty from '@/app/shared/types/difficulty';
import { NavegateService } from '@/app/core/services/navegate/navegate.services';


@Component({
  selector: 'app-level-sheet',
  imports: [LevelHeader, ThemeNamesContainer, LevelButton],
  templateUrl: './level-sheet.html',
  styleUrl: './level-sheet.css',
})
export class LevelSheet {

  difficulty = input.required<Difficulty>();
  navegateService = inject(NavegateService);

  navegate() {
    this.navegateService.goTheme(this.difficulty().id);
  }
}
