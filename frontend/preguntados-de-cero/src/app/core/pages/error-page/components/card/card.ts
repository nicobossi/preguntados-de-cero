import { Component, inject } from '@angular/core';
import {ErrorCode} from '@/app/core/pages/error-page/components/error-code/error-code';
import {ErrorDescription} from '@/app/core/pages/error-page/components/error-description/error-description';
import { ButtonNavegate } from "@/app/features/end-game/components/button-navegate/button-navegate";
import { NavegateService } from '@/app/core/services/navegate/navegate.services';

@Component({
  selector: 'app-card',
  imports: [
    ErrorCode,
    ErrorDescription,
    ButtonNavegate
],
  templateUrl: './card.html',
  styleUrl: './card.css',
})
export class Card {
  private navegate = inject(NavegateService);

  onClick() {
    this.navegate.goHome();
  }
}
