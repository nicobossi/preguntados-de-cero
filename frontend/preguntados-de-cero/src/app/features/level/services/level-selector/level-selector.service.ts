import Difficulty from "@/app/shared/types/difficulty";
import { Injectable, signal } from "@angular/core";



@Injectable()
export class LevelSelectorService {

  private levels = signal<Difficulty[]>([]);
  private isChangeLevel = signal<boolean>(false);
  private index = signal<number>(0);

  setLevels(difficulties: Difficulty[]) : void {
    this.levels.set(difficulties);
  }

  finishChange() {
    this.isChangeLevel.set(false);
  }

  changeToPrevLevel() : void {
    this.isChangeLevel.set(true);
    this.moveLevel(i => i - 1);
  }

  changeToNextLevel() : void {
    this.isChangeLevel.set(true);
    this.moveLevel(i => i + 1);
  }

  isInitChange() : boolean {
    return this.isChangeLevel();
  }

  isFirstLevel(): boolean {
    return this.levels().indexOf(this.currentLevel()) === 0;
  }

  isLastLevel() : boolean {
    return this.levels().indexOf(this.currentLevel()) === this.levels().length - 1;
  }

  currentLevel() : Difficulty {
    return this.levels()[this.index()];
  }

  private moveLevel(changeLevel : (i : number) => number) : void {
    this.index.update(i => changeLevel(i));
  }
}
