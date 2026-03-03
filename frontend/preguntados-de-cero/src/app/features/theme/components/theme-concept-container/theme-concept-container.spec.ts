import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ThemeConceptContainer } from './theme-concept-container';

describe('ThemeConceptContainer', () => {
  let component: ThemeConceptContainer;
  let fixture: ComponentFixture<ThemeConceptContainer>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ThemeConceptContainer]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ThemeConceptContainer);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
