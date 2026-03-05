import { Routes } from '@angular/router';
import { Level } from './features/level/level';
import { InitGame } from './features/init-game/init-game';
import {Theme} from '@/app/features/theme/theme';
import {
  END_GAME_URL,
  HOME_URL,
  LEVEL_URL,
  QUESTION_PARAMS_URL,
  RECAP_URL,
  SERVER_ERROR_URL,
  THEME_PARAMS_URL
} from './shared/routes/routes';
import { StartGame } from './features/start-game/start-game';
import { ErrorPage } from './core/pages/error-page/error-page';
import {Recap} from '@/app/features/recap/recap';
import {EndGame} from '@/app/features/end-game/end-game';
import { ErrorServerPage } from './core/pages/error-server-page/error-server-page';

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
    path: END_GAME_URL,
    component: EndGame
  },
  {
    path: RECAP_URL,
    component: Recap
  },
  {
    path: SERVER_ERROR_URL,
    component: ErrorServerPage
  },
  {
    path: '**',
    component: ErrorPage
  }
];
