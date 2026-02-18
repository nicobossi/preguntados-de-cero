import {Component, output} from '@angular/core';

@Component({
  selector: 'app-play-again-button',
  imports: [],
  templateUrl: './play-again-button.html',
  styleUrl: './play-again-button.css',
})
export class PlayAgainButton {
  navegate = output<void>();

  onClick() {
    this.navegate.emit();
  }
}
