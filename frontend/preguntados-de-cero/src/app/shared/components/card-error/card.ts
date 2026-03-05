import { Component, inject, input } from '@angular/core';
import {ErrorCode} from '@/app/shared/components/error-code/error-code';
import {ErrorDescription} from '@/app/shared/components/error-description/error-description';
import { ButtonNavegate } from "@/app/features/end-game/components/button-navegate/button-navegate";
import { NavegateService } from '@/app/core/services/navegate/navegate.services';

@Component({
  selector: 'app-card-error',
  imports: [
    ErrorCode,
    ErrorDescription,
    ButtonNavegate
],
  templateUrl: './card.html',
  styleUrl: './card.css',
})
export class CardError {

  private navegate = inject(NavegateService);
  code = input.required<number>();
  codeMessage = input.required<string>();
  errorDescription = input.required<string>();

  onClick() {
    this.navegate.goHome();
  }
}
