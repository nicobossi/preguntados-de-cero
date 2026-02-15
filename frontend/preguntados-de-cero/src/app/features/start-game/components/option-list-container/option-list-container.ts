import { Component, inject } from '@angular/core';
import { Option } from '@/app/shared/types/option';
import { ResultService } from '../../services/result.service';
import { OptionButton } from "../option-button/option-button";
import { NextButton } from '../next-button/next-button';

@Component({
  selector: 'app-option-list-container',
  imports: [OptionButton, NextButton],
  templateUrl: './option-list-container.html',
  styleUrl: './option-list-container.css',
})
export class OptionListContainer {

  private service = inject(ResultService);

  protected options() : Option[] {
    return this.service.currentOptions();
  }
}
