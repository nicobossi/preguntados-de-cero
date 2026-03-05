import { Component, inject } from '@angular/core';
import {ErrorCode} from '@/app/core/pages/error-page/components/error-code/error-code';
import {ErrorDescription} from '@/app/core/pages/error-page/components/error-description/error-description';
import { ButtonNavegate } from "@/app/features/end-game/components/button-navegate/button-navegate";
import { Router } from '@angular/router';

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
  private router = inject(Router);

  onClick() {
    this.router.navigate(['']);
  }
}
