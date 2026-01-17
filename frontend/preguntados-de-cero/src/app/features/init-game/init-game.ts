import {Component} from '@angular/core';
import {FormContainer} from '@/app/features/init-game/components/form-container/form-container';
import {InitLogo} from '@/app/features/init-game/components/init-logo/init-logo';
import { HeaderGame } from './components/header-game/header-game';

@Component({
  selector: 'app-init-game',
  imports: [
    HeaderGame,
    FormContainer,
    InitLogo
  ],
  templateUrl: './init-game.html',
  styleUrl: './init-game.css',
})
export class InitGame {

}
