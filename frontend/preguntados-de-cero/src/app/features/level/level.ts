import { Component, inject, OnInit, signal } from '@angular/core';
import { AppHeader } from '../../shared/components/app-header/header';
import { ButtonsContainer } from './components/buttons-container/buttons-container';
import { LevelService } from './services/level/level.service';
import { Observable } from 'rxjs';
import Difficulty from '../../shared/types/difficulty';

@Component({
  selector: 'app-level',
  imports: [AppHeader, ButtonsContainer],
  templateUrl: './level.html',
  styleUrl: './level.css',
})
export class Level implements OnInit {

  private service = inject(LevelService);
  protected difficulties = signal<Difficulty[]>([]);
  protected color = "#6640B7";

  ngOnInit() : void {

    const response : Observable<Difficulty[]> = this.service.getAll();
    response.subscribe({
      next: (difficulties) => this.difficulties.set(difficulties),
      error: (error : unknown) => console.error(error)
    })
  }
}
