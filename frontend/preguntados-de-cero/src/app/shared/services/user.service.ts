import { inject, Injectable, signal } from "@angular/core";
import { User } from "../types/user";
import { LoadStateService } from "@/app/core/services/load-state/load-state.service";
import { HttpClient } from "@angular/common/http";
import { JwtService } from "@/app/core/services/auth/jwt.service";
import { NavegateService } from "@/app/core/services/navegate/navegate.services";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private user = signal<User | null>(null);
  private httpHandler = inject(LoadStateService);
  private httpClient = inject(HttpClient);
  private authService = inject(JwtService);
  private navegateService = inject(NavegateService);
  private url = '/api/v1/user/me';

  save(user: User) {
    this.user.set(user);
  }

  get getUser() {
    if (this.user()) return this.user()
    else if(this.authService.isAuthenticate()) return this.refreshMe();
    this.navegateService.goLogin();

  }

  private refreshMe() {
    this.httpHandler.handleResponse(
      () => this.httpClient.get(this.url),
      this.save
    )
  }
}
