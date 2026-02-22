import { Component, inject } from '@angular/core';
import { NextButton } from "../next-button/next-button";
import { PrevButton } from "../prev-button/prev-button";
import { LevelSelectorService } from '../../services/level-selector/level-selector.service';

@Component({
  selector: 'app-movement-buttons',
  imports: [NextButton, PrevButton],
  templateUrl: './movement-buttons.html',
  styleUrl: './movement-buttons.css',
})
export class MovementButtons {

  private service = inject(LevelSelectorService);

  onChangeToPrevLevel() : void {
    this.service.changeToPrevLevel();
  }

  onChangeToNextLevel() : void {
    this.service.changeToNextLevel();
  }

  get getIsFirstLevel() : boolean {
    return this.service.isFirstLevel();
  }

  get getIsLastLevel() : boolean {
    return this.service.isLastLevel();
  }
}
