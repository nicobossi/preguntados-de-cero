import Difficulty from "@/app/shared/types/difficulty";
import { Injectable, signal } from "@angular/core";



@Injectable()
export class LevelSelectorService {

  private levels = signal<Difficulty[]>([]);
  private index = 0;

  setLevels(difficulties: Difficulty[]) : void {
    this.levels.set(difficulties);
  }

  changeToPrevLevel() : void {
    this.index--;
  }

  changeToNextLevel() : void {
    this.index++;
  }

  isFirstLevel(): boolean {
    return this.levels().indexOf(this.levels()[this.index]) === 0;
  }

  isLastLevel() : boolean {
    return this.levels().indexOf(this.levels()[this.index]) === this.levels().length - 1;
  }

  currentLevel() : Difficulty {
    return this.levels()[this.index];
  }
}
