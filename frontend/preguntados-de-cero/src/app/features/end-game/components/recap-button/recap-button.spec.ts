import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecapButton } from './recap-button';

describe('RecapButton', () => {
  let component: RecapButton;
  let fixture: ComponentFixture<RecapButton>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RecapButton]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RecapButton);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
