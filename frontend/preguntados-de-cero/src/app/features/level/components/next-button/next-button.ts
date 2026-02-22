import { Component, input, output } from '@angular/core';
import { DisableButton } from "@/app/shared/components/disable-button/disable-button";

@Component({
  selector: 'app-next-button',
  imports: [DisableButton],
  templateUrl: './next-button.html',
  styleUrl: './next-button.css',
})
export class NextButton {

  onNextLevel = output<void>();
  isLastLevel = input.required<boolean>();

  onClick() {
    this.onNextLevel.emit()
  }
}
