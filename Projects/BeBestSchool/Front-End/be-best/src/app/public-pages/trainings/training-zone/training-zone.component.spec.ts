import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrainingZoneComponent } from './training-zone.component';

describe('TrainingZoneComponent', () => {
  let component: TrainingZoneComponent;
  let fixture: ComponentFixture<TrainingZoneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TrainingZoneComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TrainingZoneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
