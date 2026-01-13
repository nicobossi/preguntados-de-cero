import { Component, Input } from '@angular/core';
import Difficulty from '../../../../shared/types/difficulty';

@Component({
  selector: 'app-level-button',
  imports: [],
  templateUrl: './level-button.html',
  styleUrl: './level-button.css',
})
export class LevelButton {

  @Input() difficulty! : Difficulty;
}
