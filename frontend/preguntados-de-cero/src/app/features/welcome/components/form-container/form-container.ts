import { Component } from '@angular/core';
import {NameForm} from '@/app/features/welcome/components/name-form/name-form';

@Component({
  selector: 'app-form-container',
  imports: [
    NameForm,
  ],
  templateUrl: './form-container.html',
  styleUrl: './form-container.css',
})
export class FormContainer {

}
