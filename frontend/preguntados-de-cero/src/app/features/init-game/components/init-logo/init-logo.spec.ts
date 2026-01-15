import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InitLogo } from './init-logo';

describe('InitLogo', () => {
  let component: InitLogo;
  let fixture: ComponentFixture<InitLogo>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InitLogo]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InitLogo);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
