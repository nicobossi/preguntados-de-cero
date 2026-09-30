import { inject, Injectable, signal } from "@angular/core";
import { Credentials } from "../../../core/services/auth/types/credentials";
import { LoadStateService } from "../../../core/services/load-state/load-state.service";
import { HttpClient } from "@angular/common/http";
import { User } from "@/app/shared/types/user";
import { JwtService } from "@/app/core/services/auth/jwt.service";

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private httpClient = inject(HttpClient);
  private user = signal<User | null>(null);
  private error = signal<Error | null>(null);
  private jwtService = inject(JwtService);
  private loading = signal(false);
  private url = '/api/v1/auth/login';

  execute(credentials: Credentials) {
    this.loading.set(true);

    const user = this.httpClient.post<User>(this.url, credentials, {observe: 'response'});

    user.subscribe({
      next: (response) => {
        this.user.set(response.body);
        this.jwtService.auth(response.headers);
      },
      error: (error) => this.error.set(error),
      complete: () => this.loading.set(false)
    })
  }

  get getUser() {
    return this.user()
  }
}
