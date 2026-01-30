import {Component, Input} from '@angular/core';
import GameTheme from '@/app/shared/types/gameTheme';

@Component({
  selector: 'app-theme-description',
  imports: [],
  templateUrl: './theme-description.html',
  styleUrl: './theme-description.css',
})
export class ThemeDescription {
  @Input() theme! : GameTheme;
}
