import { inject, Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class PlayerName {
  private name: string = "";
  private router : Router = inject(Router);

  setName(name: string): void {
    this.name = name;
  }

  get getName(): string{
    return this.name;
  }

  saveName(name: string): void {
    this.setName(name);
    console.log("Name " + this.getName)
    this.router.navigate(["/level"]);
  }
}
