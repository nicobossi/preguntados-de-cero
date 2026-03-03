import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ThemeContainer } from './theme-container';

describe('ThemeContainer', () => {
  let component: ThemeContainer;
  let fixture: ComponentFixture<ThemeContainer>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ThemeContainer]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ThemeContainer);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
