import { Question } from "@/app/shared/types/question";
import { HttpClient } from "@angular/common/http";
import { inject, Injectable, signal } from "@angular/core";
import { GameService } from "./game.service";


@Injectable()
export class QuestionService {

  private resultService = inject(GameService);
  private http = inject(HttpClient)
  private path = "http://localhost:8080/api/question"
  private isLoading = signal<boolean>(false);
  private isError = signal<boolean>(false);

  execute(themeId : number) : void {

    this.isLoading.set(true);
    const response = this.http.get<Question[]>(`${this.path}/${themeId}`);

    response.subscribe({
      next: (questions : Question[]) => this.resultService.setQuestions(questions),
      error: (_ : unknown) => this.isError.set(true),
      complete: () => this.isLoading.set(false)
    })
  }

  get getIsLoading() : boolean {
    return this.isLoading()
  }
}
