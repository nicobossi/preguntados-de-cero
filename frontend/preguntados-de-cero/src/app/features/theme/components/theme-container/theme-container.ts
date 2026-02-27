import { Component, inject } from '@angular/core';
import { CardsContainer } from "../cards-container/cards-container";
import { ThemeConceptContainer } from "../theme-concept-container/theme-concept-container";
import { ConceptService } from '../../services/concept.service';

@Component({
  selector: 'app-theme-container',
  imports: [CardsContainer, ThemeConceptContainer],
  providers: [ConceptService],
  templateUrl: './theme-container.html',
  styleUrl: './theme-container.css',
})
export class ThemeContainer {

  private conceptoService = inject(ConceptService);

  get getConcept() : string | null {
    return this.conceptoService.getConcept;
  }
}
