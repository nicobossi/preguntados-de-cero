import { Component } from '@angular/core';
import { InitDesktopImage } from "@/app/shared/components/init-desktop-image/init-desktop-image";
import { CardError } from "@/app/shared/components/card-error/card";

@Component({
  selector: 'app-error-server-page',
  imports: [InitDesktopImage, CardError],
  templateUrl: './error-server-page.html',
  styleUrl: './error-server-page.css',
})
export class ErrorServerPage {

}
