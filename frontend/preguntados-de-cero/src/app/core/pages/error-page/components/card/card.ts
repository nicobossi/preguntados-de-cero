import { Component } from '@angular/core';
import {ErrorCode} from '@/app/core/pages/error-page/components/error-code/error-code';
import {ErrorDescription} from '@/app/core/pages/error-page/components/error-description/error-description';
import {HomeButton} from '@/app/core/pages/error-page/components/home-button/home-button';

@Component({
  selector: 'app-card',
  imports: [
    ErrorCode,
    ErrorDescription,
    HomeButton
  ],
  templateUrl: './card.html',
  styleUrl: './card.css',
})
export class Card {

}
