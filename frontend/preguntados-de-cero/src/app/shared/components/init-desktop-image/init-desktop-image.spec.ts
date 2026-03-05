import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InitDesktopImage } from './init-desktop-image';

describe('InitDesktopImage', () => {
  let component: InitDesktopImage;
  let fixture: ComponentFixture<InitDesktopImage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InitDesktopImage]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InitDesktopImage);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
