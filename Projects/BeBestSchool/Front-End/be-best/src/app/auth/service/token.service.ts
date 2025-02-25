import { Injectable } from '@angular/core';
import { AUTH_CONST } from 'src/app/app-config/app.conestant';

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  constructor() { }

  getToken(): string | null {
    return localStorage.getItem(AUTH_CONST.access_token);
  }

  saveToken(token: string): void {
    localStorage.setItem(AUTH_CONST.access_token, token);
  }

  removeToken(): void {
    localStorage.removeItem(AUTH_CONST.access_token);
  }

  setUserLoginStatus(userLoginStatus: string): void {
    localStorage.setItem(AUTH_CONST.is_user_in, userLoginStatus);
  }

  removeUserLoginStatus(): void {
    localStorage.removeItem(AUTH_CONST.is_user_in);
  }

  getUserLoginStatus(): string | null {
    return localStorage.getItem(AUTH_CONST.is_user_in);
  }
}
