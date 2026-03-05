import { Component } from '@angular/core';
import {Card} from '@/app/core/pages/error-page/components/card/card';
import { InitDesktopImage } from "@/app/shared/components/init-desktop-image/init-desktop-image";

@Component({
  selector: 'app-error-page',
  imports: [
    Card,
    InitDesktopImage
],
  templateUrl: './error-page.html',
  styleUrl: './error-page.css',
})
export class ErrorPage {

}
