import { Component } from '@angular/core';
import {WelcomeHeader} from '@/app/features/welcome/components/welcome-header/welcome-header';
import {ImageFormContainer} from '@/app/features/welcome/components/image-form-container/image-form-container';

@Component({
  selector: 'app-welcome',
  imports: [
    WelcomeHeader,
    ImageFormContainer
  ],
  templateUrl: './welcome.html',
  styleUrl: './welcome.css',
})
export class Welcome {

}
