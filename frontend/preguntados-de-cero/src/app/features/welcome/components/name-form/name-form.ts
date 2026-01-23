import {Component, inject} from '@angular/core';
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {InputAlert} from '@/app/features/welcome/components/input-alert/input-alert';
import {PlayButton} from '@/app/features/welcome/components/play-button/play-button';
import {Router} from '@angular/router';
import {PlayerName} from '@/app/core/services/player-name/player-name';

@Component({
  selector: 'app-name-form',
  imports: [
    ReactiveFormsModule,
    InputAlert,
    PlayButton,
  ],
  templateUrl: './name-form.html',
  styleUrl: './name-form.css',
})
export class NameForm {
  private router = inject(Router);
  private nameService = inject(PlayerName);

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
    if (this.nameform.valid) {
      this.nameService.setName(this.name.value!);
      console.log('Nombre guardado: ', this.nameService.getName()); /*debug hasta que se implemente la pagina de review fin de juego*/
      this.router.navigate(['/level']);
    }
  }
}
