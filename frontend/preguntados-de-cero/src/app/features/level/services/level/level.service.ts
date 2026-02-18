import { HttpClient } from "@angular/common/http";
import { inject, Injectable } from "@angular/core";
import Difficulty from "../../../../shared/types/difficulty";
import { LoadStateService } from "@/app/core/services/load-state/load-state.service";


@Injectable()
export class LevelService {

  private url : string = "http://localhost:8080/api/difficulty";
  private httpClient = inject(HttpClient);
  private loadService = inject(LoadStateService<Difficulty>);

  getAll() : void {
    this.loadService.handleResponse(() => this.httpClient.get<Difficulty[]>(this.url));
  }

  get getDifficulties() : Difficulty[] {
    return this.loadService.getData;
  }

  get getIsLoading() : boolean {
    return this.loadService.getIsLoading;
  }
}



