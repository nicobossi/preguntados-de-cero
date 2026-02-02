import {Component, inject, Input} from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-level-button',
  templateUrl: './level-button.html',
  styleUrl: './level-button.css',
})
export class LevelButton {

  @Input() id! : number;

  private router = inject(Router);

  onClick() {
    console.log('Dificultad elegida: ', this.id);
    this.router.navigate(['/theme', this.id]);
  }
}
