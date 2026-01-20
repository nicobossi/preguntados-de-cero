import {Component, Input} from '@angular/core';
import Theme from '@/app/shared/types/theme';

@Component({
  selector: 'app-theme-description',
  imports: [],
  templateUrl: './theme-description.html',
  styleUrl: './theme-description.css',
})
export class ThemeDescription {
  @Input() theme! : Theme;
}
