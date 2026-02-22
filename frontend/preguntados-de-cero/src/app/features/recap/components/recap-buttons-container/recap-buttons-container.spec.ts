import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecapButtonsContainer } from './recap-buttons-container';

describe('RecapButtonsContainer', () => {
  let component: RecapButtonsContainer;
  let fixture: ComponentFixture<RecapButtonsContainer>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RecapButtonsContainer]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RecapButtonsContainer);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
