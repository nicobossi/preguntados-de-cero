import { Component, input, Input } from '@angular/core';
import { BackgroundColorDirective } from '../../directives/background-color/background-color-directive';

@Component({
  selector: 'app-header',
  imports: [BackgroundColorDirective],
  templateUrl: './header.html',
  styleUrl: './header.css',
})
export class AppHeader {

  color = input.required<string>();
  title = input.required<string>();
}
