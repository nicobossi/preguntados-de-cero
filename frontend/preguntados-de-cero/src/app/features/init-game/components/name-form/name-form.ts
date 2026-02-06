import {Component, inject, output} from '@angular/core';
import {ReactiveFormsModule} from '@angular/forms';
import {PlayButton} from '@/app/features/init-game/components/play-button/play-button';
import { FormErrorsContainer } from "../form-errors-container/form-errors-container";
import { InitForm } from '../../services/init-form.service';
import { InputName } from "../input-name/input-name";

@Component({
  selector: 'app-name-form',
  imports: [
    PlayButton,
    ReactiveFormsModule,
    FormErrorsContainer,
    InputName
],
  templateUrl: './name-form.html',
  styleUrl: './name-form.css',
})
export class NameForm {

  protected initFormService = inject(InitForm);
  submitName = output<void>();

  protected onSubmitName() {
    this.submitName.emit();
  }
}
