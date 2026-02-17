import { LEVEL_URL, QUESTION_URL, THEME_URL } from "@/app/shared/routes/routes";
import { inject, Injectable } from "@angular/core";
import { Router } from "@angular/router";



@Injectable({
  providedIn: 'root'
})
export class NavegateService {
  private router = inject(Router);

  goLevel() {
    this.router.navigate([LEVEL_URL]);
  }

  goTheme(id : number) : void {
    console.log('Dificultad elegida: ', id);
    this.router.navigate([THEME_URL, id]);
  }

  goQuestion(id : number) : void {
    this.router.navigate([QUESTION_URL, id]);
  }

  goErrorLoad(error : unknown) : void {

  }
}
