import { Component, input, output } from '@angular/core';
import { DisableButton } from "@/app/shared/components/disable-button/disable-button";

@Component({
  selector: 'app-prev-button',
  imports: [DisableButton],
  templateUrl: './prev-button.html',
  styleUrl: './prev-button.css',
})
export class PrevButton {

  onPrevLevel = output<void>();
  isFirstLevel = input.required<boolean>();

  onClick() {
    this.onPrevLevel.emit()
  }
}
