import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InfoButton } from './info-button';

describe('InfoButton', () => {
  let component: InfoButton;
  let fixture: ComponentFixture<InfoButton>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InfoButton]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InfoButton);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
