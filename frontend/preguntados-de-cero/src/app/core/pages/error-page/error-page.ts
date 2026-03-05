import { Component } from '@angular/core';
import {CardError} from '@/app/shared/components/card-error/card';
import { InitDesktopImage } from "@/app/shared/components/init-desktop-image/init-desktop-image";

@Component({
  selector: 'app-error-page',
  imports: [
    CardError,
    InitDesktopImage
],
  templateUrl: './error-page.html',
  styleUrl: './error-page.css',
})
export class ErrorPage {

  protected errorDescription = "Lo sentimos, la página solicitada no existe o se ha eliminado. Por favor, compruebe la dirección introducida."
}
