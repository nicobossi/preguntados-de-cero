import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ThemesNameCard } from './themes-name-card';

describe('ThemesNameCard', () => {
  let component: ThemesNameCard;
  let fixture: ComponentFixture<ThemesNameCard>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ThemesNameCard]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ThemesNameCard);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
