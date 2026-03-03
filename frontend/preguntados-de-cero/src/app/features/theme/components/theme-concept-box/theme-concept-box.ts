import { Component, input } from '@angular/core';

@Component({
  selector: 'app-theme-concept-box',
  templateUrl: './theme-concept-box.html',
  styleUrl: './theme-concept-box.css',
})
export class ThemeConceptBox {

  concept = input.required<string | null>();
}
