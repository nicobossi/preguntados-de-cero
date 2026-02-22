import { Component, inject } from '@angular/core';
import { GameService } from '../../services/game.service';
import { DisableButton } from "@/app/shared/components/disable-button/disable-button";

@Component({
  selector: 'app-next-button',
  imports: [DisableButton],
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
