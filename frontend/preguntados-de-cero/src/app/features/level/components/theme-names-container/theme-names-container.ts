import { Component, input } from '@angular/core';
import GameTheme from '@/app/shared/types/gameTheme';

@Component({
  selector: 'app-theme-names-container',
  templateUrl: './theme-names-container.html',
  styleUrl: './theme-names-container.css',
})
export class ThemeNamesContainer {

  themes = input<GameTheme[]>();

  protected get getThemes() {
    return this.themes()
  }
}
