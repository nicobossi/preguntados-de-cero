import {Component} from '@angular/core';
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {PlayButton} from '@/app/features/init-game/components/play-button/play-button';

@Component({
  selector: 'app-name-form',
  imports: [
    PlayButton,
    ReactiveFormsModule,
  ],
  templateUrl: './name-form.html',
  styleUrl: './name-form.css',
})
export class NameForm {
  nameform = new FormGroup({
    name: new FormControl('',[
      Validators.required,
      Validators.minLength(3),
      Validators.maxLength(20),
    ]),
  })

  get name() {
    return this.nameform.controls.name;
  }

  protected onSubmit() {

  }
}
