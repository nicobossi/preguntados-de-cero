import { Routes } from '@angular/router';
import { Level } from './features/level/level';
import { InitGame } from './features/init-game/init-game';
import {Theme} from '@/app/features/theme/theme';
import { HOME_URL, LEVEL_URL, QUESTION_PARAMS_URL, THEME_PARAMS_URL } from './shared/routes/routes';
import { StartGame } from './features/start-game/start-game';
import { ErrorPage } from './core/pages/error-page/error-page';

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
    path: QUESTION_PARAMS_URL,
    component: StartGame
  },
  {
    path: '**',
    component: ErrorPage
  }
];
