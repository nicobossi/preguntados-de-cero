import { Component } from '@angular/core';
import {Card} from '@/app/features/error-page/components/card/card';

@Component({
  selector: 'app-error-page',
  imports: [
    Card
  ],
  templateUrl: './error-page.html',
  styleUrl: './error-page.css',
})
export class ErrorPage {

}
