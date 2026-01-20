import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class DifficultyService {
  private selectedDifficultyId: number | null = null;

  setDifficultyId(id: number) {
    this.selectedDifficultyId = id;
  }

  getDifficultyId(): number | null {
    return this.selectedDifficultyId;
  }
}
