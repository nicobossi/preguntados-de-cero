import { Injectable, signal } from "@angular/core";



@Injectable({
  providedIn: "root"
})
export class ConceptService {

  private concept = signal<string | null>(null);

  get getConcept() : string | null{
    return this.concept();
  }

  setConcept(concept : string) : void {
    this.concept.set(concept);
  }
}
