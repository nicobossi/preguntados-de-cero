import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OptionListContainer } from './option-list-container';

describe('OptionListContainer', () => {
  let component: OptionListContainer;
  let fixture: ComponentFixture<OptionListContainer>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [OptionListContainer]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OptionListContainer);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
