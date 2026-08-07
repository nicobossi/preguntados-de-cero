import { Credentials } from '@/app/core/services/auth/types/credentials';
import { Component, input, output } from '@angular/core';
import { FormControl, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-form',
  templateUrl: './form.html',
  styleUrl: './form.css',
  imports: [ReactiveFormsModule],
})
export class Form {
  onLogin = output<Credentials>();
  isInvalid = false;
  form = new FormGroup({
    email: new FormControl(
      '',
      [
        Validators.required,
        Validators.email
      ]),
    password: new FormControl(
      '',
      [
        Validators.required
      ])
  });

  protected execute() {
    this.isInvalid = this.form.invalid;

    if(!this.isInvalid) {
      this.onLogin.emit({
        email: this.form.controls.email.value!,
        password: this.form.controls.password.value!
      });
    }
  }

  protected isEmptyEmail(): boolean {
    return this.isInvalid && this.form.controls.email.hasError("required");
  }

  protected isInvalidEmail(): boolean {
    return this.isInvalid && this.form.controls.email.hasError("email");
  }

  protected isEmptyPassword(): boolean {
    return this.isInvalid && this.form.controls.password.hasError("required");
  }
}
