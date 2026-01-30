import { Component, inject } from '@angular/core';
import { LevelButton } from '../level-button/level-button';
import { LevelService } from '../../services/level/level.service';

@Component({
  selector: 'app-buttons-container',
  imports: [LevelButton],
  templateUrl: './buttons-container.html',
  styleUrl: './buttons-container.css',
})
export class ButtonsContainer {

  private service = inject(LevelService);

  protected get getDifficulties() {
    return this.service.getDifficulties;
  }
}
