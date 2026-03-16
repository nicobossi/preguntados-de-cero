import { HttpClient } from "@angular/common/http";
import { inject, Injectable, signal } from "@angular/core";
import Difficulty from "../../../../shared/types/difficulty";
import { LoadStateService } from "@/app/core/services/load-state/load-state.service";
import { LevelSelectorService } from "../level-selector/level-selector.service";
import { environment} from '@/environments/environment';


@Injectable()
class LevelService {

  private url : string = environment.apiBackendUrl + "/api/difficulty";
  private httpClient = inject(HttpClient);
  private loadService = inject(LoadStateService<Difficulty>);
  private levelSelectorService = inject(LevelSelectorService);

  getAll() : void {
    this.loadService.handleResponse(
      () => this.httpClient.get<Difficulty[]>(this.url),
      (responseData : Difficulty[]) => this.levelSelectorService.setLevels(responseData));
  }

  get getIsLoading() : boolean {
    return this.loadService.getIsLoading;
  }
}

export default LevelService



