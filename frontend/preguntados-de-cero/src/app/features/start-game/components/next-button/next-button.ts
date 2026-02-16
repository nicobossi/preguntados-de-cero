import { Component, inject } from '@angular/core';
import { GameService } from '../../services/game.service';

@Component({
  selector: 'app-next-button',
  imports: [],
  templateUrl: './next-button.html',
  styleUrl: './next-button.css',
})
export class NextButton {

  private service = inject(GameService);

  protected haveAnswer() : boolean {
    return this.service.getHaveAnsware;
  }

  protected next() : void {
    this.service.goNextQuestion();
  }
}
