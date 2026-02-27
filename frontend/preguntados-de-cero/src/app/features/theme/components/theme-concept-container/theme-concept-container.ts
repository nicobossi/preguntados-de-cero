import { Component, inject } from '@angular/core';
import { ConceptService } from '../../services/concept.service';

@Component({
  selector: 'app-theme-concept-container',
  imports: [],
  templateUrl: './theme-concept-container.html',
  styleUrl: './theme-concept-container.css',
})
export class ThemeConceptContainer {
  private conceptService = inject(ConceptService);

  get getConcept() : string | null {
    return this.conceptService.getConcept;
  }
}
