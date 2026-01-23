import { Routes } from '@angular/router';
import { Level } from './features/level/level';
import {Welcome} from '@/app/features/welcome/welcome';

export const routes: Routes = [
  {
    path: '',
    component: Welcome
  },
  {
    path: 'level',
    component: Level
  }
];
