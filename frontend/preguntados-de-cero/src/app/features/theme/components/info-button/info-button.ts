import {Component, Input} from '@angular/core';
import GameTheme from '@/app/shared/types/gameTheme';

@Component({
  selector: 'app-info-button',
  imports: [],
  templateUrl: './info-button.html',
  styleUrl: './info-button.css',
})
export class InfoButton {
  @Input() theme! : GameTheme;
}
