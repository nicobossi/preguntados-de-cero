export interface AuthenticationService<T extends object> {
  auth: (data: T) => void
}
