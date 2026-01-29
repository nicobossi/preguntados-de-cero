import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HeaderGame } from './header-game';

describe('HeaderGame', () => {
  let component: HeaderGame;
  let fixture: ComponentFixture<HeaderGame>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HeaderGame]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HeaderGame);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
