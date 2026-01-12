import { Directive, input } from "@angular/core";


@Directive({
  selector: "[appBackgroundColor]",
  host: {
    "[style.backgroundColor]": "appBackgroundColor()"
  }
})
export class BackgroundColorDirective {

  appBackgroundColor = input.required<string>();
}
