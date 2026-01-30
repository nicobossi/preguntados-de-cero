import { Routes } from '@angular/router';
import { Level } from './features/level/level';
import { InitGame } from './features/init-game/init-game';
import {Theme} from '@/app/features/theme/theme';

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
    path: 'theme/:difficultyId',
    component: Theme
  },
];
