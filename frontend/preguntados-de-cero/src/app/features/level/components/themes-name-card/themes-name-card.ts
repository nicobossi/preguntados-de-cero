import { Component, input, output } from '@angular/core';

@Component({
  selector: 'app-themes-name-card',
  imports: [],
  templateUrl: './themes-name-card.html',
  styleUrl: './themes-name-card.css',
})
export class ThemesNameCard {

  onOffChange = output<void>();
  themeNames = input.required<string[]>();
  isChange = input.required<boolean>();
}
