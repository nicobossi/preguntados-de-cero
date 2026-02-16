import { Option } from '@/app/shared/types/option';
import { Component, inject, input, output, signal } from '@angular/core';
import { ResultService } from '../../services/result.service';

@Component({
  selector: 'app-option-button',
  templateUrl: './option-button.html',
  styleUrl: './option-button.css',
})
export class OptionButton {

  option = input.required<Option>();
  service = inject(ResultService);
  protected isFail = signal<boolean>(false);

  protected onAnswer() : void {
    if(!this.option().isCorrect) this.isFail.set(true);
    this.service.registerAnswer(this.option());
  }

  protected haveAnsware() : boolean {
    return this.service.getHaveAnsware
  }
}
