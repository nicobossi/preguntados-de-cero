import {Component, inject} from '@angular/core';
import { NameForm } from "./components/name-form/name-form";
import { PlayerName } from '@/app/core/services/player-name/player-name';
import { InitForm } from './services/init-form.service';
import { InitDesktopImage } from '@/app/shared/components/init-desktop-image/init-desktop-image';

@Component({
  selector: 'app-init-game',
  imports: [
    InitDesktopImage,
    NameForm
],
  templateUrl: './init-game.html',
  styleUrl: './init-game.css',
})
export class InitGame {

  private nameService = inject(PlayerName);
  protected initFormService = inject(InitForm);

  protected saveName() {
    if (this.initFormService.isValidForm()) this.nameService.saveName(this.initFormService.getValue);
  }
}
