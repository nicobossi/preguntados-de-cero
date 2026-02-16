import {Component, inject, Input, WritableSignal} from '@angular/core';
import GameTheme from '@/app/shared/types/gameTheme';
import {NgClass} from '@angular/common';
import { NavegateService } from '@/app/core/services/navegate/navegate.services';

@Component({
  selector: 'app-theme-button',
  imports: [NgClass],
  templateUrl: './theme-button.html',
  styleUrl: './theme-button.css',
})
export class ThemeButton {
  @Input() theme! : GameTheme;
  @Input() isDescriptionVisible! : WritableSignal<boolean>;
  private navegateService = inject(NavegateService);

  protected navegate() {
    this.navegateService.goQuestion(this.theme.id);
  }
}
