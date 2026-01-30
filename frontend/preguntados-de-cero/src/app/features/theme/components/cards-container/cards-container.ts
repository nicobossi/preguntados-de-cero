import {Component, Input} from '@angular/core';
import GameTheme from '@/app/shared/types/gameTheme';
import {ThemeCard} from '@/app/features/theme/components/theme-card/theme-card';

@Component({
  selector: 'app-cards-container',
  imports: [
    ThemeCard
  ],
  templateUrl: './cards-container.html',
  styleUrl: './cards-container.css',
})
export class CardsContainer {
  @Input() themes! : GameTheme[];
}
