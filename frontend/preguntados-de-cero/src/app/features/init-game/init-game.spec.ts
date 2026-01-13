import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InitGame } from './init-game';

describe('InitGame', () => {
  let component: InitGame;
  let fixture: ComponentFixture<InitGame>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InitGame]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InitGame);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
