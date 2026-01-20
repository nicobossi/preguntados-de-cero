import {Component, Input} from '@angular/core';
import Theme from '@/app/shared/types/theme';
import {ThemeSelector} from '@/app/features/theme/components/theme-selector/theme-selector';
import {ThemeInfo} from '@/app/features/theme/components/theme-info/theme-info';
import {ThemeDescription} from '@/app/features/theme/components/theme-description/theme-description';

@Component({
  selector: 'app-theme-button',
  imports: [
    ThemeSelector,
    ThemeInfo,
    ThemeDescription
  ],
  templateUrl: './theme-button.html',
  styleUrl: './theme-button.css',
})
export class ThemeButton {
  @Input() theme! : Theme;
}
