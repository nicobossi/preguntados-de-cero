import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrevButton } from './prev-button';

describe('PrevButton', () => {
  let component: PrevButton;
  let fixture: ComponentFixture<PrevButton>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PrevButton]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PrevButton);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
