import {Component, inject} from '@angular/core';
import {PlayerName} from '@/app/core/services/player-name/player-name';

@Component({
  selector: 'app-congratulations',
  imports: [],
  templateUrl: './congratulations.html',
  styleUrl: './congratulations.css',
})
export class Congratulations {
  private nameService = inject(PlayerName)

  private getPlayerName(): string {
    return this.nameService.getName;
  }

  congratulations() : string {
    return "¡Felicitaciones, " + this.getPlayerName() + "!";
  }
}
