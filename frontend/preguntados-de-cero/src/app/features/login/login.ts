import { FormContainer } from '@/app/shared/components/form-container/form-container';
import { Component } from '@angular/core';
import { ButtonContainer } from './components/button-container/button-container';
import { Form } from "./components/form/form";

@Component({
  selector: 'app-login',
  imports: [FormContainer, ButtonContainer, Form],
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login {

}
