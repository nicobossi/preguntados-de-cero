import {inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import GameTheme from '@/app/shared/types/gameTheme';
import { LoadStateService } from '@/app/core/services/load-state/load-state.service';


@Injectable({
  providedIn: 'root',
})
export class ThemeService {

  private http = inject(HttpClient);
  private baseUrl: string = 'http://localhost:8080/api/theme';
  private loadService = inject(LoadStateService);

  getAllByDifficultyId(difficultyId: string) : void {
    this.loadService.handleResponse(() => this.http.get<GameTheme[]>(`${this.baseUrl}/${difficultyId}`));
  }

  get getThemes() : GameTheme[] {
    return this.loadService.getData;
  }

  get getIsLoading() : boolean {
    return this.loadService.getIsLoading;
  }
}
