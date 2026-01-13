import { HttpClient } from "@angular/common/http";
import { inject, Injectable } from "@angular/core";
import { Observable } from "rxjs";
import Difficulty from "../../../../shared/types/difficulty";


@Injectable({providedIn: 'root'})
export class LevelService {

  private url : string = "http://localhost:8080/api/difficulty";
  private httpClient = inject(HttpClient);

  getAll() : Observable<Difficulty[]> {
    return this.httpClient.get<Difficulty[]>(this.url);
  }
}



