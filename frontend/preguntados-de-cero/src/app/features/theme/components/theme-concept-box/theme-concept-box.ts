import { Component, inject } from '@angular/core';
import { ConceptService } from '../../services/concept.service';

@Component({
  selector: 'app-theme-concept-box',
  templateUrl: './theme-concept-box.html',
  styleUrl: './theme-concept-box.css',
})
export class ThemeConceptBox {
  private conceptService = inject(ConceptService);

  get getConcept() : string | null {
    return this.conceptService.getConcept;
  }
}
