import { Component, input } from '@angular/core';

@Component({
  selector: 'app-error-description',
  imports: [],
  templateUrl: './error-description.html',
  styleUrl: './error-description.css',
})
export class ErrorDescription {

  errorDescription = input.required<string>();
}
