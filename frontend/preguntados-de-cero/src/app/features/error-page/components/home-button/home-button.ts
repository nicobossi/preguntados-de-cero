import {Component, inject} from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-home-button',
  imports: [],
  templateUrl: './home-button.html',
  styleUrl: './home-button.css',
})
export class HomeButton {
  private router = inject(Router);

  onClick() {
    this.router.navigate(['']);
  }
}
