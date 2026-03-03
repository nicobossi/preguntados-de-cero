import { Component, input, output } from '@angular/core';

@Component({
  selector: 'app-button-navegate',
  imports: [],
  templateUrl: './button-navegate.html',
  styleUrl: './button-navegate.css',
})
export class ButtonNavegate {

  text = input.required<string>();
  onNavegate = output<void>();

  onClick() : void {
    this.onNavegate.emit();
  }
}
