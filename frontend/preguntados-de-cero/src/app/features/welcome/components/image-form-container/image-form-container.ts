import { Component } from '@angular/core';
import {DesktopImage} from '@/app/features/welcome/components/desktop-image/desktop-image';
import {FormContainer} from '@/app/features/welcome/components/form-container/form-container';

@Component({
  selector: 'app-image-form-container',
  imports: [
    DesktopImage,
    FormContainer
  ],
  templateUrl: './image-form-container.html',
  styleUrl: './image-form-container.css',
})
export class ImageFormContainer {

}
