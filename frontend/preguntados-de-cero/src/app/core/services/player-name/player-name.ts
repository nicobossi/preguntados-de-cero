import {Injectable, signal} from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class PlayerName {
  private nameSignal = signal<string>('');
  readonly name = this.nameSignal.asReadonly();

  setName(name: string): void {
    this.nameSignal.set(name);
  }

  getName(): string {
    return this.nameSignal();
  }
}
