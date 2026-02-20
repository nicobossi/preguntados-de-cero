import { AfterViewChecked, Component, inject, input, output } from '@angular/core';
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
export class LevelSheet implements AfterViewChecked {

  difficulty = input.required<Difficulty>();
  isChange = input.required<boolean>();
  onOffChange = output<void>();
  navegateService = inject(NavegateService);

  ngAfterViewChecked() : void {
    setTimeout(() => this.onOffChange.emit(), 3000);
  }

  navegate() {
    this.navegateService.goTheme(this.difficulty().id);
  }

  onOffGlass() {
    this.onOffChange.emit();
  }

  articleClass() : string {
    return this.isChange() ? 'open-card' : 'glass-card-container';
  }

  cardClass() : string {
    return this.isChange() ? 'float-container' : 'falling-container';
  }
}
