import { inject, Injectable, signal } from "@angular/core";
import { Credentials } from "../../../core/services/auth/types/credentials";
import { HttpClient } from "@angular/common/http";
import { User } from "@/app/shared/types/user";
import { JwtService } from "@/app/core/services/auth/jwt.service";
import { UserService } from "@/app/shared/services/user.service";
import { NavegateService } from "@/app/core/services/navegate/navegate.services";

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private httpClient = inject(HttpClient);
  private jwtService = inject(JwtService);
  private userService = inject(UserService);
  private navegationService = inject(NavegateService);
  private error = signal<Error | null>(null);
  private loading = signal(false);
  private url = '/api/v1/auth/login';

  execute(credentials: Credentials) {
    this.loading.set(true);

    const user = this.httpClient.post<User>(this.url, credentials, {observe: 'response'});

    user.subscribe({
      next: (response) => {
        this.jwtService.auth(response.headers);
        this.userService.save(response.body!);
        this.navegationService.goAddAdmin();
      },
      error: (error) => this.error.set(error),
      complete: () => this.loading.set(false)
    })
  }
}
