import { Component, inject } from '@angular/core';
import { QuestionService } from './services/question.service';
import { ActivatedRoute } from '@angular/router';
import { QuestionContainer } from "./components/question-container/question-container";
import { OptionListContainer } from "./components/option-list-container/option-list-container";
import { GameService } from './services/game.service';
import { CounterService } from '../../core/services/counter-game/counter.service';
import { OptionService } from './services/option.service';

@Component({
  selector: 'app-start-game',
  imports: [QuestionContainer, OptionListContainer],
  providers: [
    QuestionService,
    GameService,
    OptionService
  ],
  templateUrl: './start-game.html',
  styleUrl: './start-game.css',
})
export class StartGame {

  questionsService = inject(QuestionService);
  private router = inject(ActivatedRoute);


  ngOnInit() {
    this.router.params.subscribe(params => this.questionsService.getAll(params["themeId"]));
  }
}
