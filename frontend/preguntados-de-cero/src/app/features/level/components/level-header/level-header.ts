import { Component, input } from '@angular/core';

@Component({
  selector: 'app-level-header',
  imports: [],
  templateUrl: './level-header.html',
  styleUrl: './level-header.css',
})
export class LevelHeader {

  level = input<number>();
}
