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

  handleResponse(observable : Observable<T>) {
    observable.subscribe({
      next: data => this.data.set(data),
      error: error => this.navegate.goErrorLoad(error),
      complete: () => this.isLoading.set(false)
    });
  }

  initLoad() : void {
    this.isLoading.set(true);
  }

  get getData() : T | null {
    return this.data();
  }
}
