import { Component, Input } from '@angular/core';
import { LevelButton } from '../level-button/level-button';
import Difficulty from '@/app/shared/types/difficulty';

@Component({
  selector: 'app-buttons-container',
  imports: [LevelButton],
  templateUrl: './buttons-container.html',
  styleUrl: './buttons-container.css',
})
export class ButtonsContainer {

  @Input() difficulties! : Difficulty[]
}
