import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DesktopImage } from './desktop-image';

describe('DesktopImage', () => {
  let component: DesktopImage;
  let fixture: ComponentFixture<DesktopImage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DesktopImage]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DesktopImage);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
