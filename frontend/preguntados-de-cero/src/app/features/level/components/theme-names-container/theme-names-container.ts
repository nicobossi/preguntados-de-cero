import { Component, input } from '@angular/core';

@Component({
  selector: 'app-theme-names-container',
  imports: [],
  templateUrl: './theme-names-container.html',
  styleUrl: './theme-names-container.css',
})
export class ThemeNamesContainer {

  themeNames = input<string[]>();

  protected get getNames() {
    return this.themeNames()
  }
}
