import {Component, Input, WritableSignal} from '@angular/core';
import GameTheme from '@/app/shared/types/gameTheme';
import {NgClass} from '@angular/common';

@Component({
  selector: 'app-theme-button',
  imports: [NgClass],
  templateUrl: './theme-button.html',
  styleUrl: './theme-button.css',
})
export class ThemeButton {
  @Input() theme! : GameTheme;
  @Input() isDescriptionVisible! : WritableSignal<boolean>;
}
