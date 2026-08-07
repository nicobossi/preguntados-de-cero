import { FormContainer } from '@/app/shared/components/form-container/form-container';
import { Component, inject } from '@angular/core';
import { ButtonContainer } from './components/button-container/button-container';
import { Form } from "./components/form/form";
import { Credentials } from '@/app/core/services/auth/types/credentials';
import { LoginService } from '@/app/features/login/services/login.service';

@Component({
  selector: 'app-login',
  imports: [FormContainer, ButtonContainer, Form],
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login {
  service = inject(LoginService);

  login(credentials: Credentials) {
    this.service.execute(credentials);
  }
}
