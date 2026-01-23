import { Component } from '@angular/core';
import {Logo} from '@/app/features/welcome/components/logo/logo';

@Component({
  selector: 'app-welcome-header',
  imports: [
    Logo
  ],
  templateUrl: './welcome-header.html',
  styleUrl: './welcome-header.css',
})
export class WelcomeHeader {

}
