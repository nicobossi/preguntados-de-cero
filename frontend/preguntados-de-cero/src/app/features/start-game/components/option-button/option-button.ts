import { Option } from '@/app/shared/types/option';
import { Component, input, output, signal } from '@angular/core';


@Component({
  selector: 'app-option-button',
  templateUrl: './option-button.html',
  styleUrl: './option-button.css'
})
export class OptionButton {

  option = input.required<Option>();
  haveResult = input.required<boolean>();
  onSubmitAnswer = output<Option>();
  protected isFail = signal<boolean>(false);

  protected onAnswer() : void {
    if(!this.option().isCorrect) this.isFail.set(true);
    this.onSubmitAnswer.emit(this.option());
  }
}
