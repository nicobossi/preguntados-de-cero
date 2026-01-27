import {Component, Input} from '@angular/core';
import GameTheme from '@/app/shared/types/gameTheme';
import {
  ThemesButtonsContainer
} from '@/app/features/theme/components/themes-buttons-container/themes-buttons-container';
import {ThemeDescription} from '@/app/features/theme/components/theme-description/theme-description';

@Component({
  selector: 'app-theme-card',
  imports: [
    ThemesButtonsContainer,
    ThemeDescription
  ],
  templateUrl: './theme-card.html',
  styleUrl: './theme-card.css',
})
export class ThemeCard {
  @Input() theme! : GameTheme;
}
