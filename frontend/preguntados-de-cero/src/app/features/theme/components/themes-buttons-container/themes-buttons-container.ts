import {Component, Input, WritableSignal} from '@angular/core';
import GameTheme from '@/app/shared/types/gameTheme';
import {ThemeButton} from '@/app/features/theme/components/theme-button/theme-button';
import {InfoButton} from '@/app/features/theme/components/info-button/info-button';
import {NgClass} from '@angular/common';

@Component({
  selector: 'app-themes-buttons-container',
  imports: [
    ThemeButton,
    InfoButton,
    NgClass
  ],
  templateUrl: './themes-buttons-container.html',
  styleUrl: './themes-buttons-container.css',
})
export class ThemesButtonsContainer {
  @Input() theme! : GameTheme;
  @Input() isDescriptionVisible! : WritableSignal<boolean>;

}
