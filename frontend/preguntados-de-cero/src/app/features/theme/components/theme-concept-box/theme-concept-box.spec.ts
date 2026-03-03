import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ThemeConceptBox } from './theme-concept-box';

describe('ThemeConceptBox', () => {
  let component: ThemeConceptBox;
  let fixture: ComponentFixture<ThemeConceptBox>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ThemeConceptBox]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ThemeConceptBox);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
