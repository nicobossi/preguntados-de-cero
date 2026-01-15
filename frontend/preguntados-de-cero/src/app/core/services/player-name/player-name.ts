import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class PlayerName {
  private name: string = "";

  setName(name: string): void{
    this.name = name;
  }

  getName(): string{
    return this.name;
  }
}
