import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ThemesButtonsContainer } from './themes-buttons-container';

describe('ThemesButtonsContainer', () => {
  let component: ThemesButtonsContainer;
  let fixture: ComponentFixture<ThemesButtonsContainer>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ThemesButtonsContainer]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ThemesButtonsContainer);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
