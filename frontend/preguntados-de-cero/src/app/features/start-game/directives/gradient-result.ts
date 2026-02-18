import { Directive, effect, ElementRef, inject } from '@angular/core';
import { GameService } from '../services/game.service';

@Directive({
  selector: '[appGradientResult]',
})
export class GradientResultDirective {

  private gameService = inject(GameService);
  private element = inject(ElementRef);

  constructor() {

    effect(() => {

      if(this.gameService.isCorrectResultSignal()) {
        this.element.nativeElement.style.background = this.resultGradient();
        this.element.nativeElement.style.color = '#111'
      }
      else {
        this.element.nativeElement.style.background = '';
        this.element.nativeElement.style.color = '';
      }
    })
  }
  private resultGradient() : string {
    return this.gameService.isCorrectResult ? 'var(--assert-gradient)' : 'var(--fail-gradient)'
  }
}
