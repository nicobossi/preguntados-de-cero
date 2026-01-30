import {Component, inject, Input} from '@angular/core';
import Difficulty from '../../../../shared/types/difficulty';
import {Router} from '@angular/router';

@Component({
  selector: 'app-level-button',
  templateUrl: './level-button.html',
  styleUrl: './level-button.css',
})
export class LevelButton {

  @Input() difficulty! : Difficulty;

  private router = inject(Router);

  onClick() {
    console.log('Dificultad elegida: ', this.difficulty.id); // borrar desp, solo debug
    this.router.navigate(['/theme', this.difficulty.id]);
  }
}
