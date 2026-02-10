import {Component, output} from '@angular/core';

@Component({
  selector: 'app-level-button',
  templateUrl: './level-button.html',
  styleUrl: './level-button.css',
})
export class LevelButton {

  navegate = output<void>();

  onClick() {
    this.navegate.emit();
  }
}
