import { Component, inject, OnInit } from '@angular/core';
import { AppHeader } from '@/app/shared/components/app-header/header';
import { ButtonsContainer } from './components/buttons-container/buttons-container';
import { LevelService } from './services/level/level.service';

@Component({
  selector: 'app-level',
  imports: [AppHeader, ButtonsContainer],
  templateUrl: './level.html',
  styleUrl: './level.css'
})
export class Level {

  protected services = inject(LevelService);

  ngOnInit() : void {
    this.services.getAll();
  }
}
