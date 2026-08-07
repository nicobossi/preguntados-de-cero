import { HttpHandlerFn, HttpRequest } from "@angular/common/http";
import { inject } from "@angular/core";
import { JwtService } from "./jwt.service";

export function addJwtTokenInterceptor(
  req: HttpRequest<unknown>,
  next: HttpHandlerFn
) {
  const jwt = inject(JwtService).getToken();

  const inReq = req.clone({
    headers: req.headers.set('Authorization', `Bearer ${jwt}`)
  })

  return next(inReq);
}
