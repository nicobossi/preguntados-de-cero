import {inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {DifficultyService} from '@/app/core/services/difficulty/difficulty.service';
import {Observable} from 'rxjs';
import Theme from '@/app/shared/types/theme';

@Injectable({
  providedIn: 'root',
})
export class ThemeService {

  private httpClient = inject(HttpClient);
  private difficultyService: DifficultyService = inject(DifficultyService);
  private baseUrl: string = 'http://localhost:8080/api/theme'; // ← URL base

  getAll(): Observable<Theme[]> {
    return this.httpClient.get<Theme[]>(`${this.baseUrl}/${this.difficultyService.getDifficultyId()}`);
  }

}
