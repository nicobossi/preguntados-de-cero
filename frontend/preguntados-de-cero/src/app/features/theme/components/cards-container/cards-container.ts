import {Component, inject} from '@angular/core';
import GameTheme from '@/app/shared/types/gameTheme';
import {ThemeCard} from '@/app/features/theme/components/theme-card/theme-card';
import { ThemeService } from '../../services/theme.service';

@Component({
  selector: 'app-cards-container',
  imports: [
    ThemeCard
  ],
  templateUrl: './cards-container.html',
  styleUrl: './cards-container.css',
})
export class CardsContainer {
  private service = inject(ThemeService);

  protected get getThemes(): GameTheme[]{
    return this.service.getThemes;
  }
}
