import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ThemeInfo } from './theme-info';

describe('ThemeInfo', () => {
  let component: ThemeInfo;
  let fixture: ComponentFixture<ThemeInfo>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ThemeInfo]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ThemeInfo);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
