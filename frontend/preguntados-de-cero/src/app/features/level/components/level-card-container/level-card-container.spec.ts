import { ComponentFixture, TestBed } from '@angular/core/testing';
import { LevelCardContainer } from './level-card-container';


describe('ButtonsContainer', () => {
  let component: LevelCardContainer;
  let fixture: ComponentFixture<LevelCardContainer>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LevelCardContainer]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LevelCardContainer);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
