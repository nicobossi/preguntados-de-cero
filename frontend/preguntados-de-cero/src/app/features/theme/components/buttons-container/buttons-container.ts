import {Component, Input} from '@angular/core';
import {ThemeButton} from '@/app/features/theme/components/theme-button/theme-button';
import Theme from '@/app/shared/types/theme';

@Component({
  selector: 'app-buttons-container',
  imports: [
    ThemeButton
  ],
  templateUrl: './buttons-container.html',
  styleUrl: './buttons-container.css',
})
export class ButtonsContainer {
  @Input() themes! : Theme[];
}
