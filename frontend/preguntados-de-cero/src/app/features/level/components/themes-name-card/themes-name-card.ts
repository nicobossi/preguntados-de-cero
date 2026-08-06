import { Component, input, output } from '@angular/core';
import GameTheme from '@/app/shared/types/gameTheme';

@Component({
  selector: 'app-themes-name-card',
  templateUrl: './themes-name-card.html',
  styleUrl: './themes-name-card.css',
})
export class ThemesNameCard {

  onOffChange = output<void>();
  themes = input.required<GameTheme[]>();
  isChange = input.required<boolean>();

  cardClass() : string {
    return this.isChange() ? 'float-container' : 'falling-container'
  }

  onOffAnimation() : void {
    this.onOffChange.emit();
  }
}
