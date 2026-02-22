import {Component, inject} from '@angular/core';
import {CounterService} from '@/app/core/services/counter-game/counter.service';
import {PlayerName} from '@/app/core/services/player-name/player-name';
import {ResultService} from '@/app/core/services/result-game/result.service';
import {AppHeader} from '@/app/shared/components/app-header/header';
import {AnswersContainer} from '@/app/features/recap/components/answers-container/answers-container';

@Component({
  selector: 'app-recap',
  imports: [
    AppHeader,
    AnswersContainer
  ],
  templateUrl: './recap.html',
  styleUrl: './recap.css',
})
export class Recap { // revisar esto una vez que se termine con endgame!
  private counterService = inject(CounterService);
  private nameService = inject(PlayerName)
  private resultService = inject(ResultService)

  ngOnInit(){
    this.mostrarResultados(); // esto es debug, borrar despues!
  }

  private mostrarResultados() : void {
    this.resultService.getResultGame.forEach(
      (qr) => {console.log(qr)}
    )
  }
}
