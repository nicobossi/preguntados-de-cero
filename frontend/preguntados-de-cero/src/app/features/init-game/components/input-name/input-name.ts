import { Component, input } from '@angular/core';
import { FormControl, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-input-name',
  imports: [ReactiveFormsModule],
  templateUrl: './input-name.html',
  styleUrl: './input-name.css',
})
export class InputName {

  inputName = input.required<FormControl>();
}
