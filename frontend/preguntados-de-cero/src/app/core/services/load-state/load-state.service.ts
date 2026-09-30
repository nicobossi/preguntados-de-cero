import { inject, Injectable, signal } from "@angular/core";
import { Observable } from "rxjs";
import { NavegateService } from "../navegate/navegate.services";


@Injectable({
  providedIn: 'root'
})
export class LoadStateService<T> {

  private isLoading = signal<boolean>(false);
  private navegate = inject(NavegateService);

  handleResponse(execute : () => Observable<T>, save : (data : T) => void, path?: string) {

    this.isLoading.set(true);

    execute().subscribe({
      next:  data  => save(data),
      error: error => this.navegate.goErrorLoad(path ?? error),
      complete: () => this.isLoading.set(false)
    });
  }

  get getIsLoading() : boolean {
    return this.isLoading();
  }
}
