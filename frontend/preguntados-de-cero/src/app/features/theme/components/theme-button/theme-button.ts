import {Component, Input} from '@angular/core';
import GameTheme from '@/app/shared/types/gameTheme';

@Component({
  selector: 'app-theme-button',
  imports: [],
  templateUrl: './theme-button.html',
  styleUrl: './theme-button.css',
})
export class ThemeButton {
  @Input() theme! : GameTheme;
}
