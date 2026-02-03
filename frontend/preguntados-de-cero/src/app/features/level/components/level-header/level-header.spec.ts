import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LevelHeader } from './level-header';

describe('LevelHeader', () => {
  let component: LevelHeader;
  let fixture: ComponentFixture<LevelHeader>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LevelHeader]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LevelHeader);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
