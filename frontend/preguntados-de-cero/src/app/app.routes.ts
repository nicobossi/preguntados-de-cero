import { Routes } from '@angular/router';
import { Level } from './features/level/level';
import { InitGame } from './features/init-game/init-game';
import {ThemeComponent} from '@/app/features/theme/theme.component';

export const routes: Routes = [
  {
    path: '',
    component: InitGame
  },
  {
    path: 'level',
    component: Level
  },
  {
    path: 'theme',
    component: ThemeComponent
  }
];
