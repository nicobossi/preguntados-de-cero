import {Component, inject, Input, WritableSignal} from '@angular/core';
import GameTheme from '@/app/shared/types/gameTheme';
import {NgClass} from '@angular/common';
import { ConceptService } from '../../services/concept.service';

@Component({
  selector: 'app-info-button',
  imports: [NgClass],
  templateUrl: './info-button.html',
  styleUrl: './info-button.css',
})
export class InfoButton {
  private conceptService = inject(ConceptService);
  @Input() theme! : GameTheme;
  @Input() isDescriptionVisible! : WritableSignal<boolean>;

  protected onClick() {
    this.conceptService.setConcept(this.theme.description);
    this.isDescriptionVisible.update(v => !v);
  }
}
