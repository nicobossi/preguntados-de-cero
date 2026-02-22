import {Component, inject} from '@angular/core';
import {ReplayButton} from '@/app/features/recap/components/replay-button/replay-button';
import {NavegateService} from '@/app/core/services/navegate/navegate.services';

@Component({
  selector: 'app-recap-buttons-container',
  imports: [
    ReplayButton
  ],
  templateUrl: './recap-buttons-container.html',
  styleUrl: './recap-buttons-container.css',
})
export class RecapButtonsContainer {
  navegateService = inject(NavegateService);

  navegateToLevel() {
    this.navegateService.goLevel();
  }
}
