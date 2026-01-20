import {Component, Input} from '@angular/core';
import Theme from '@/app/shared/types/theme';

@Component({
  selector: 'app-theme-selector',
  imports: [],
  templateUrl: './theme-selector.html',
  styleUrl: './theme-selector.css',
})
export class ThemeSelector {
  @Input() theme! : Theme;
}
