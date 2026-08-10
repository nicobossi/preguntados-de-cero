import {ADD_PAGE_URL, END_GAME_URL, LEVEL_URL, LOGIN_URL, QUESTION_URL, RECAP_URL, SERVER_ERROR_URL, THEME_URL} from "@/app/shared/routes/routes";
import { inject, Injectable } from "@angular/core";
import { Router } from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class NavegateService {
  private router = inject(Router);

  goHome() {
    this.router.navigate(['']);
  }

  goLevel() {
    this.router.navigate([LEVEL_URL]);
  }

  goTheme(id : number) : void {
    this.router.navigate([THEME_URL, id]);
  }

  goQuestion(id : number) : void {
    this.router.navigate([QUESTION_URL, id]);
  }

  goErrorLoad(path? : string) : void {
    this.router.navigate([path ?? SERVER_ERROR_URL]);
  }

  goEndGame(){
    this.router.navigate([END_GAME_URL]);
  }

  goRecap() {
    this.router.navigate([RECAP_URL]);
  }

  goAddAdmin() {
    this.router.navigate([ADD_PAGE_URL]);
  }

  goLogin() {
    this.router.navigate([LOGIN_URL]);
  }
}
