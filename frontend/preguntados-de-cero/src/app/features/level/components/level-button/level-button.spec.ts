import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LevelButton } from './level-button';

describe('LevelButton', () => {
  let component: LevelButton;
  let fixture: ComponentFixture<LevelButton>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LevelButton]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LevelButton);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
