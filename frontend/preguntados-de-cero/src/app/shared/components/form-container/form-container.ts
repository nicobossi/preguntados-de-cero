import { NgStyle } from '@angular/common';
import { Component, input } from '@angular/core';

@Component({
  selector: 'app-form-container',
  imports: [],
  templateUrl: './form-container.html',
  styleUrl: './form-container.css',
})
export class FormContainer {
  backgroundColor = input.required<string>()
}
