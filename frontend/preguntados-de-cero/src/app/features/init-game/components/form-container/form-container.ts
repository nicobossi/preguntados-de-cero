import { Component } from '@angular/core';
import {InitLogo} from '@/app/features/init-game/components/init-logo/init-logo';
import {NameForm} from '@/app/features/init-game/components/name-form/name-form';

@Component({
  selector: 'app-form-container',
  imports: [
    InitLogo,
    NameForm,
  ],
  templateUrl: './form-container.html',
  styleUrl: './form-container.css',
})
export class FormContainer {

}
