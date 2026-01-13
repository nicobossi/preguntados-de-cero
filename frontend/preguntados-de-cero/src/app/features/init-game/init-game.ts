import {Component, OnInit} from '@angular/core';
import {AppHeader} from '@/app/shared/components/app-header/header';
import {FormContainer} from '@/app/features/init-game/components/form-container/form-container';

@Component({
  selector: 'app-init-game',
  imports: [
    AppHeader,
    FormContainer
  ],
  templateUrl: './init-game.html',
  styleUrl: './init-game.css',
})
export class InitGame {

}
