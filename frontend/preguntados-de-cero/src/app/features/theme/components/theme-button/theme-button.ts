import {Component, inject, Input} from '@angular/core';
import GameTheme from '@/app/shared/types/gameTheme';
import { NavegateService } from '@/app/core/services/navegate/navegate.services';

@Component({
  selector: 'app-theme-button',
  templateUrl: './theme-button.html',
  styleUrl: './theme-button.css',
})
export class ThemeButton {
  @Input() theme! : GameTheme;
  private navegateService = inject(NavegateService);

  protected navegate() {
    this.navegateService.goQuestion(this.theme.id);
  }
}
