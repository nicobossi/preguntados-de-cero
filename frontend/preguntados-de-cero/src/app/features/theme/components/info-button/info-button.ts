import {Component, Input, WritableSignal} from '@angular/core';
import GameTheme from '@/app/shared/types/gameTheme';
import {NgClass} from '@angular/common';

@Component({
  selector: 'app-info-button',
  imports: [NgClass],
  templateUrl: './info-button.html',
  styleUrl: './info-button.css',
})
export class InfoButton {
  @Input() theme! : GameTheme;
  @Input() isDescriptionVisible! : WritableSignal<boolean>;

  protected onClick() {
    this.isDescriptionVisible.update(v => !v);
  }
}
