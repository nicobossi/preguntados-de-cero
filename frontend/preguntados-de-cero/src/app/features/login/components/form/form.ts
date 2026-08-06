import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-form',
  templateUrl: './form.html',
  styleUrl: './form.css',
  imports: [ReactiveFormsModule],
})
export class Form {
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
  })
}
