import {Component, inject} from '@angular/core';
import {CounterService} from '@/app/core/services/counter-game/counter.service';
import {PlayerName} from '@/app/core/services/player-name/player-name';

@Component({
  selector: 'app-recap',
  imports: [],
  templateUrl: './recap.html',
  styleUrl: './recap.css',
})
export class Recap {
  private counterService = inject(CounterService);
  private nameService = inject(PlayerName)

  ngOnInit(){
    console.log("Jugador: " + this.nameService.getName);
    console.log("preguntas totales: " + this.counterService.getTotal);
    console.log("preguntas bien respondidas: " + this.counterService.getTotalCorrectAnswers);
    console.log("preguntas mal respondidas: " + this.counterService.getTotalIncorrectAnswers());
  }
}
