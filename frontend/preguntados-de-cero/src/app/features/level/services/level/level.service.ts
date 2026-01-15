import { HttpClient } from "@angular/common/http";
import { inject, Injectable, signal, Signal } from "@angular/core";
import Difficulty from "../../../../shared/types/difficulty";
import { Observable } from "rxjs";


@Injectable()
export class LevelService {

  private url : string = "http://localhost:8080/api/difficulty";
  private httpClient = inject(HttpClient);
  private difficulties = signal<Difficulty[]>([]);
  private isLoading = signal<boolean>(false);
  private isError = signal<boolean>(false);

  getAll() : void {

    this.isLoading.set(true);
    const response : Observable<Difficulty[]> = this.httpClient.get<Difficulty[]>(this.url);

    response.subscribe({
      next: (difficulties : Difficulty[]) => this.difficulties.set(difficulties),
      error: (error : unknown) => this.isError.set(true),
      complete: () => this.isLoading.set(false)
    })
  }

  get getDifficulties() : Difficulty[] {
    return this.difficulties();
  }

  get getIsError() : boolean {
    return this.isError();
  }

  get getIsLoading() : boolean {
    return this.isLoading();
  }
}



