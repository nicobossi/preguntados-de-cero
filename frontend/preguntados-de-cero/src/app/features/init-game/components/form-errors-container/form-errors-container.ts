import { Component, inject } from '@angular/core';
import { InitForm } from '../../services/init-form.service';

@Component({
  selector: 'app-form-errors-container',
  imports: [],
  templateUrl: './form-errors-container.html',
  styleUrl: './form-errors-container.css',
})
export class FormErrorsContainer {
  protected service = inject(InitForm);
}
