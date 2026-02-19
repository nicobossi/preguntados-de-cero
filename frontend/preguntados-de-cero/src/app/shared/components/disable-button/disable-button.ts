import { Component, input, output } from '@angular/core';

@Component({
  selector: 'app-disable-button',
  imports: [],
  templateUrl: './disable-button.html',
  styleUrl: './disable-button.css',
})
export class DisableButton {

  isDisable = input.required<boolean>();
  content = input.required<string>();
  onEmit = output();

  onClick() {
    this.onEmit.emit();
  }
}
