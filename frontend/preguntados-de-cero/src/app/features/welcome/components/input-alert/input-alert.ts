import {Component, Input} from '@angular/core';
import {FormControl} from '@angular/forms';

@Component({
  selector: 'app-input-alert',
  imports: [],
  templateUrl: './input-alert.html',
  styleUrl: './input-alert.css',
})
export class InputAlert {
  @Input() control!: FormControl;
}
