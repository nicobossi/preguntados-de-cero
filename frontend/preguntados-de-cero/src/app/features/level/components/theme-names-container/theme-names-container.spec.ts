import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ThemeNamesContainer } from './theme-names-container';

describe('ThemeNamesContainer', () => {
  let component: ThemeNamesContainer;
  let fixture: ComponentFixture<ThemeNamesContainer>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ThemeNamesContainer]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ThemeNamesContainer);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
