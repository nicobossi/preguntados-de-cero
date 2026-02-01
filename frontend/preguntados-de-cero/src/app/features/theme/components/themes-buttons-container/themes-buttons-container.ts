import {Component, Input, Signal, WritableSignal} from '@angular/core';
import GameTheme from '@/app/shared/types/gameTheme';
import {ThemeButton} from '@/app/features/theme/components/theme-button/theme-button';
import {InfoButton} from '@/app/features/theme/components/info-button/info-button';

@Component({
  selector: 'app-themes-buttons-container',
  imports: [
    ThemeButton,
    InfoButton
  ],
  templateUrl: './themes-buttons-container.html',
  styleUrl: './themes-buttons-container.css',
})
export class ThemesButtonsContainer {
  @Input() theme! : GameTheme;
  @Input() isDescriptionVisible! : WritableSignal<boolean>;

}
