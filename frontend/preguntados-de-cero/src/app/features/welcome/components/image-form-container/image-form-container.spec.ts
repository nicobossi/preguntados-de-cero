import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImageFormContainer } from './image-form-container';

describe('ImageFormContainer', () => {
  let component: ImageFormContainer;
  let fixture: ComponentFixture<ImageFormContainer>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ImageFormContainer]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ImageFormContainer);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
