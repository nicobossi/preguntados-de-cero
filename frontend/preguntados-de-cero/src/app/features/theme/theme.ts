import {Component, inject} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import { ThemeContainer } from './components/theme-container/theme-container';
import { ThemeService } from './services/theme.service';
import { StateLoader } from "@/app/shared/components/state-loader/state-loader";

@Component({
  selector: 'app-theme',
  imports: [ThemeContainer, StateLoader],
  providers: [ThemeService],
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
