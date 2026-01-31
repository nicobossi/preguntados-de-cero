import {inject, Injectable, signal} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import GameTheme from '@/app/shared/types/gameTheme';

@Injectable({
  providedIn: 'root',
})
export class ThemeService {
  private httpClient = inject(HttpClient);
  private baseUrl: string = 'http://localhost:8080/api/theme';
  private themes = signal<GameTheme[]>([]);
  private isLoading = signal<boolean>(false);
  private isError = signal<boolean>(false);

  getAllByDifficultyId(difficultyId: string) : void {

    this.isLoading.set(true);
    const response : Observable<GameTheme[]> = this.httpClient.get<GameTheme[]>(`${this.baseUrl}/${difficultyId}`);

    response.subscribe({
      next: (themes : GameTheme[]) => this.themes.set(themes),
      error: (error : unknown) => this.isError.set(true),
      complete: () => this.isLoading.set(false)
    })
  }

  get getThemes() : GameTheme[] {
    return this.themes();
  }

  get getIsError() : boolean {
    return this.isError();
  }

  get getIsLoading() : boolean {
    return this.isLoading();
  }
}
