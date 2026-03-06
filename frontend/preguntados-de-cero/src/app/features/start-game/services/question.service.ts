import { Question } from "@/app/shared/types/question";
import { HttpClient } from "@angular/common/http";
import { inject, Injectable } from "@angular/core";
import { GameService } from "./game.service";
import { LoadStateService } from "@/app/core/services/load-state/load-state.service";
import { environment } from '@/environments/environment';


@Injectable()
export class QuestionService {

  private gameService = inject(GameService);
  private http = inject(HttpClient);
  private loadService = inject(LoadStateService<GameService>);
  private path = environment.apiBackendUrl + "/api/question";

  getAll(themeId : number) : void {

    this.loadService.handleResponse(
      () => this.http.get<Question[]>(`${this.path}/${themeId}`),
      (dataResponse : Question[]) => this.gameService.setQuestions(dataResponse));
  }

  get getIsLoading() : boolean {
    return this.loadService.getIsLoading;
  }
}
