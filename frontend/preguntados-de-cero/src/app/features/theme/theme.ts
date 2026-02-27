import {Component, inject} from '@angular/core';
import {ThemeService} from '@/app/features/theme/services/theme/theme.service';
import {ActivatedRoute} from '@angular/router';
import {CardsContainer} from '@/app/features/theme/components/cards-container/cards-container';

@Component({
  selector: 'app-theme',
  imports: [CardsContainer],
  templateUrl: './theme.html',
  styleUrl: './theme.css',
})
export class Theme {
  protected themeService = inject(ThemeService);
  private route = inject(ActivatedRoute);

  constructor() {
    this.route.params.subscribe(params => {
      const difficultyId = params['difficultyId'];
      this.themeService.getAllByDifficultyId(difficultyId);
    });
  }
}
