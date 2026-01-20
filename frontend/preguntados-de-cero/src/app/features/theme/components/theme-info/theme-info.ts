import {Component, Input} from '@angular/core';
import Theme from '@/app/shared/types/theme';

@Component({
  selector: 'app-theme-info',
  imports: [],
  templateUrl: './theme-info.html',
  styleUrl: './theme-info.css',
})
export class ThemeInfo {
  @Input() theme! : Theme;
}
