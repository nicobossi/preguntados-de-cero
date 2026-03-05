import { Component, input } from '@angular/core';

@Component({
  selector: 'app-error-code',
  templateUrl: './error-code.html',
  styleUrl: './error-code.css',
})
export class ErrorCode {

  code = input.required<number>();
  message = input.required<string>();
}
