import { inject, Injectable, signal } from "@angular/core";
import { User } from "../types/user";
import { LoadStateService } from "@/app/core/services/load-state/load-state.service";
import { HttpClient } from "@angular/common/http";
import { JwtService } from "@/app/core/services/auth/jwt.service";
import { NavegateService } from "@/app/core/services/navegate/navegate.services";
import { environment } from "@/environments/environment.development";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private user = signal<User | null>(null);
  private httpHandler = inject(LoadStateService);
  private httpClient = inject(HttpClient);
  private authService = inject(JwtService);
  private navegateService = inject(NavegateService);
  private url = environment.apiBackendUrl + '/api/user/me';

  save(user: User) {
    this.user.set(user);
  }

  findUser() {
    if(!this.authService.isAuthenticate()) {
      this.navegateService.goLogin();
    }
    else {
      this.setUser()
    }
  }

  get getUser() {
    return this.user.asReadonly();
  }

  private setUser() {
    if(!this.user()) {
      this.httpHandler.handleResponse(
        () => this.httpClient.get(this.url),
        (user) => this.save(user)
      )
    }
  }

  isLoading() {
    return this.httpHandler.getIsLoading;
  }
}
