import { Component, inject } from '@angular/core';
import { ConceptService } from '../../services/concept.service';
import { ThemeConceptBox } from '../theme-concept-box/theme-concept-box';

@Component({
  selector: 'app-theme-concept-container',
  imports: [ThemeConceptBox],
  templateUrl: './theme-concept-container.html',
  styleUrl: './theme-concept-container.css',
})
export class ThemeConceptContainer {

}
