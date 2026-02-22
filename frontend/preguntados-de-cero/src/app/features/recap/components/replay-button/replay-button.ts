import {Component, output} from '@angular/core';

@Component({
  selector: 'app-replay-button',
  imports: [],
  templateUrl: './replay-button.html',
  styleUrl: './replay-button.css',
})
export class ReplayButton {
  navegate = output<void>();

  onClick() {
    this.navegate.emit();
  }
}
