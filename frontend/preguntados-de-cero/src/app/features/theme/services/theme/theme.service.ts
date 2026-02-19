import {inject, Injectable, signal} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import GameTheme from '@/app/shared/types/gameTheme';
import { LoadStateService } from '@/app/core/services/load-state/load-state.service';
import { Theme } from '../../theme';


@Injectable({
  providedIn: 'root',
})
export class ThemeService {

  private http = inject(HttpClient);
  private baseUrl: string = 'http://localhost:8080/api/theme';
  private loadService = inject(LoadStateService);
  private data = signal<GameTheme[]>([]);

  getAllByDifficultyId(difficultyId: string) : void {
    this.loadService.handleResponse(
      () => this.http.get<GameTheme[]>(`${this.baseUrl}/${difficultyId}`),
     (dataResponse : GameTheme[]) => this.data.set(dataResponse));
  }

  get getThemes() : GameTheme[] {
    return this.data();
  }

  get getIsLoading() : boolean {
    return this.loadService.getIsLoading;
  }
}
