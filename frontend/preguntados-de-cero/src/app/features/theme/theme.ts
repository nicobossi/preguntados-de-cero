import {Component, inject, signal, WritableSignal} from '@angular/core';
import {ThemeService} from '@/app/features/theme/services/theme/theme.service';
import {ActivatedRoute} from '@angular/router';
import GameTheme from '@/app/shared/types/gameTheme';
import {AppHeader} from '@/app/shared/components/app-header/header';
import {CardsContainer} from '@/app/features/theme/components/cards-container/cards-container';

@Component({
  selector: 'app-theme',
  imports: [
    AppHeader,
    CardsContainer
  ],
  templateUrl: './theme.html',
  styleUrl: './theme.css',
})
export class Theme {
  private themeService = inject(ThemeService);
  private route = inject(ActivatedRoute);
  protected themes: WritableSignal<GameTheme[]> = signal<GameTheme[]>([]);

  constructor() {
    this.route.params.subscribe(params => {
      const difficultyId = params['difficultyId']; // saco el parametro del path
      console.log('id de dificultad recibido: ', difficultyId); // debug borrar desp
      this.loadThemes(difficultyId);
    });
  }

  private loadThemes(difficultyId: string): void {
    this.themeService.getAllByDifficultyId(difficultyId).subscribe({
      next: (themes) => this.themes.set(themes),
      error: (error: unknown) => console.error(error)
    });
  }
}
