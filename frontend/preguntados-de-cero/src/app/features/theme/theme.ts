import {Component, inject} from '@angular/core';
import {ThemeService} from '@/app/features/theme/services/theme/theme.service';
import {ActivatedRoute} from '@angular/router';
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
  protected themeService = inject(ThemeService);
  private route = inject(ActivatedRoute);

  constructor() {
    this.route.params.subscribe(params => {
      const difficultyId = params['difficultyId']; // saco el parametro del path
      console.log('id de dificultad recibido: ', difficultyId); // debug borrar desp
      this.themeService.getAllByDifficultyId(difficultyId);
    });
  }

}
