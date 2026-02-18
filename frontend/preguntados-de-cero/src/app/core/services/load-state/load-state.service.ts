import { inject, Injectable, signal } from "@angular/core";
import { Observable } from "rxjs";
import { NavegateService } from "../navegate/navegate.services";


@Injectable({
  providedIn: 'root'
})
export class LoadStateService<T> {

  private isLoading = signal<boolean>(false);
  private data = signal<T | null>(null);
  private navegate = inject(NavegateService);

  handleResponse(execute : () => Observable<T>, save? : (data : T) => void) {

    this.isLoading.set(true);

    execute().subscribe({
      next: data => save ? save(data) : this.data.set(data),
      error: error => this.navegate.goErrorLoad(error),
      complete: () => this.isLoading.set(false)
    });
  }

  get getData() : T | null {
    return this.data();
  }

  get getIsLoading() : boolean {
    return this.isLoading();
  }
}
