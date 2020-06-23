import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CompareSectorChartsComponent } from './compare-sector-charts.component';

describe('CompareSectorChartsComponent', () => {
  let component: CompareSectorChartsComponent;
  let fixture: ComponentFixture<CompareSectorChartsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CompareSectorChartsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CompareSectorChartsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
