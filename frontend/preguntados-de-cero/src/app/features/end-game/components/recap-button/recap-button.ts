import {Component, output} from '@angular/core';

@Component({
  selector: 'app-recap-button',
  imports: [],
  templateUrl: './recap-button.html',
  styleUrl: './recap-button.css',
})
export class RecapButton {
  navegate = output<void>();

  onClick() {
    this.navegate.emit();
  }
}
