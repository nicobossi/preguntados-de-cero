import {Component, inject} from '@angular/core';
import {CounterService} from '@/app/core/services/counter-game/counter.service';

@Component({
  selector: 'app-recap',
  imports: [],
  templateUrl: './recap.html',
  styleUrl: './recap.css',
})
export class Recap {
  private counterService = inject(CounterService);

  ngOnInit(){
    console.log("total: " + this.counterService.getTotal);
    console.log("total correct answers: " + this.counterService.getTotalCorrectAnswers);
  }
}
