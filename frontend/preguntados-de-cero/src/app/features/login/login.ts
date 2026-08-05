import { FormContainer } from '@/app/shared/components/form-container/form-container';
import { Component } from '@angular/core';
import { ButtonContainer } from './components/button-container/button-container';

@Component({
  selector: 'app-login',
  imports: [FormContainer, ButtonContainer],
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login {

}
