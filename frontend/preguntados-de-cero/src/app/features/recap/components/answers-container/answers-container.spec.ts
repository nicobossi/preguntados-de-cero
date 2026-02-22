import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnswersContainer } from './answers-container';

describe('AnswersContainer', () => {
  let component: AnswersContainer;
  let fixture: ComponentFixture<AnswersContainer>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AnswersContainer]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AnswersContainer);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
