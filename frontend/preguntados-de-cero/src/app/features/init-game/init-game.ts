import {Component} from '@angular/core';
import { InitDesktopImage } from "./components/init-desktop-image/init-desktop-image";
import { NameForm } from "./components/name-form/name-form";

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

}
