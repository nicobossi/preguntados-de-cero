import { inject, Injectable } from "@angular/core";
import { Router } from "@angular/router";



@Injectable({
  providedIn: 'root'
})
export class NavegateService {
  private router = inject(Router);

  goLevel() {
    this.router.navigate(["/level"]);
  }

  goTheme(id : number) : void {
    console.log('Dificultad elegida: ', id);
    this.router.navigate(['/theme', id]);
  }
}
