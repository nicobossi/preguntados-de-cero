import {inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import GameTheme from '@/app/shared/types/gameTheme';

@Injectable({
  providedIn: 'root',
})
export class ThemeService {
  private httpClient = inject(HttpClient);
  private baseUrl: string = 'http://localhost:8080/api/theme';

  getAllByDifficultyId(difficultyId: string): Observable<GameTheme[]> {
    const url = `${this.baseUrl}/${difficultyId}`;
    console.log('path actual:', url); // debug borrar desp
    return this.httpClient.get<GameTheme[]>(url);
  }
}
