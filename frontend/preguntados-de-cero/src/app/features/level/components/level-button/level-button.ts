import {Component, inject, Input} from '@angular/core';
import Difficulty from '../../../../shared/types/difficulty';
import {Router} from '@angular/router';
import {DifficultyService} from '@/app/core/services/difficulty/difficulty.service';

@Component({
  selector: 'app-level-button',
  imports: [],
  templateUrl: './level-button.html',
  styleUrl: './level-button.css',
})
export class LevelButton {

  @Input() difficulty! : Difficulty;

  private router = inject(Router);
  private difficultyService: DifficultyService = inject(DifficultyService);

  onClick() {
    this.difficultyService.setDifficultyId(this.difficulty.id);
    console.log('Dificultad: ', this.difficultyService.getDifficultyId()); // borrar desp, solo debug
    this.router.navigate(['/theme']);
  }
}
