import { Component } from '@angular/core';
import { CardsContainer } from "../cards-container/cards-container";
import { ThemeConceptContainer } from "../theme-concept-container/theme-concept-container";

@Component({
  selector: 'app-theme-container',
  imports: [CardsContainer, ThemeConceptContainer],
  templateUrl: './theme-container.html',
  styleUrl: './theme-container.css',
})
export class ThemeContainer {

}
