import { Component, input } from '@angular/core';
import { NgStyle } from '@angular/common';

@Component({
  selector: 'app-header',
  imports: [NgStyle],
  templateUrl: './header.html',
  styleUrl: './header.css',
})
export class AppHeader {

  color = input.required<string>();
  title = input.required<string>();
}
