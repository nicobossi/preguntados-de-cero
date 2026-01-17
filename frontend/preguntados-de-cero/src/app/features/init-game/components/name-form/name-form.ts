import {Component, inject} from '@angular/core';
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {PlayButton} from '@/app/features/init-game/components/play-button/play-button';
import {PlayerName} from '@/app/core/services/player-name/player-name';
import {Router} from '@angular/router';

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
