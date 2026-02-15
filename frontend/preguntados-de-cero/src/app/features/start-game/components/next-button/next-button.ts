import { Component, inject } from '@angular/core';
import { ResultService } from '../../services/result.service';

@Component({
  selector: 'app-next-button',
  imports: [],
  templateUrl: './next-button.html',
  styleUrl: './next-button.css',
})
export class NextButton {

  private service = inject(ResultService);

  protected haveAnswer() : boolean {
    return this.service.getHaveAnsware;
  }

  protected next() : void {
    this.service.goNextQuestion();
  }
}
