import {END_GAME_URL, LEVEL_URL, QUESTION_URL, RECAP_URL, THEME_URL} from "@/app/shared/routes/routes";
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

  goErrorLoad(error : unknown) : void {

  }

  goEndGame(){
    this.router.navigate([END_GAME_URL]);
  }

  goRecap() {
    this.router.navigate([RECAP_URL]);
  }
}
