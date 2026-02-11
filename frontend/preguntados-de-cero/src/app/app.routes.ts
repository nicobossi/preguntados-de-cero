import { Routes } from '@angular/router';
import { Level } from './features/level/level';
import { InitGame } from './features/init-game/init-game';
import {Theme} from '@/app/features/theme/theme';
import {ErrorPage} from '@/app/features/error-page/error-page';
import { HOME_URL, LEVEL_URL, THEME_PARAMS_URL } from './shared/routes/routes';

export const routes: Routes = [
  {
    path: HOME_URL,
    component: InitGame
  },
  {
    path: LEVEL_URL,
    component: Level
  },
  {
    path: THEME_PARAMS_URL,
    component: Theme
  },
  {
    path: '**',
    component: ErrorPage
  },
];
