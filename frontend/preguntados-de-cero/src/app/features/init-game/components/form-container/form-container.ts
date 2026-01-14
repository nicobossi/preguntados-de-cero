import { Component } from '@angular/core';
import {InitLogo} from '@/app/features/init-game/components/init-logo/init-logo';
import {NameForm} from '@/app/features/init-game/components/name-form/name-form';
import {InitDesktopImage} from '@/app/features/init-game/components/init-desktop-image/init-desktop-image';

@Component({
  selector: 'app-form-container',
  imports: [
    InitLogo,
    NameForm,
    InitDesktopImage,
  ],
  templateUrl: './form-container.html',
  styleUrl: './form-container.css',
})
export class FormContainer {

}
