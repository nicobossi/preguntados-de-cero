import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ThemeDescription } from './theme-description';

describe('ThemeDescription', () => {
  let component: ThemeDescription;
  let fixture: ComponentFixture<ThemeDescription>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ThemeDescription]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ThemeDescription);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
