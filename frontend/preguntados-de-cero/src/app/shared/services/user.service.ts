import { inject, Injectable, signal } from "@angular/core";
import { User } from "../types/user";
import { LoadStateService } from "@/app/core/services/load-state/load-state.service";
import { HttpClient } from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private user = signal<User | null>(null);
  private httpHandler = inject(LoadStateService);
  private httpClient = inject(HttpClient);
  private url = '/api/v1/user/me';

  save(user: User) {
    this.user.set(user);
  }

  get getUser() {
    return this.user() ? this.user() : this.refreshMe();
  }

  private refreshMe() {
    this.httpHandler.handleResponse(
      () => this.httpClient.get(this.url),
      this.save
    )
  }
}
