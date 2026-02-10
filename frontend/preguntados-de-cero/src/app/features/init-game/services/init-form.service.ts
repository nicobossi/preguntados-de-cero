import { Injectable } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";


@Injectable({
  providedIn: 'root'
})
export class InitForm {
  private input : FormControl;
  private form : FormGroup<FormControlType>

  constructor() {
    this.input = new FormControl("", this.validators());
    this.form = new FormGroup({name: this.input});
  }

  get getForm(): FormGroup {
    return this.form;
  }

  get getControl(): FormControl<string> {
    return this.input;
  }

  get getValue(): string {
    return this.input.value;
  }

  isInvalidInput() : boolean {
    return this.input.invalid && (this.input.dirty || this.input.touched);
  }

  isValidForm(): boolean {
    return this.form.valid && this.input.value;
  }

  haveRequiredError(): boolean {
    return this.input.hasError("required");
  }

  haveMinLengthError(): boolean {
    return this.input.hasError("minlength");
  }

  haveMaxLengthError(): boolean {
    return this.input.hasError("maxlength");
  }

  private validators(): Validators {
    return [
      Validators.required,
      Validators.minLength(3),
      Validators.maxLength(20),
    ]
  }
}

interface FormControlType {
  name : FormControl<string | null>;
}
