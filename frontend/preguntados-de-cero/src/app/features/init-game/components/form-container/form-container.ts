import { Component } from '@angular/core';
import {NameForm} from '@/app/features/init-game/components/name-form/name-form';
import {InitDesktopImage} from '@/app/features/init-game/components/init-desktop-image/init-desktop-image';

@Component({
  selector: 'app-form-container',
  imports: [
    NameForm,
    InitDesktopImage,
  ],
  templateUrl: './form-container.html',
  styleUrl: './form-container.css',
})
export class FormContainer {

}
