import { Component, inject } from '@angular/core';
import { Option } from '@/app/shared/types/option';
import { QuestionService } from '../../services/question.service';

@Component({
  selector: 'app-option-list-container',
  imports: [],
  templateUrl: './option-list-container.html',
  styleUrl: './option-list-container.css',
})
export class OptionListContainer {

  private service = inject(QuestionService);

  protected options() : Option[] {
    return this.service.currentOptions();
  }
}
