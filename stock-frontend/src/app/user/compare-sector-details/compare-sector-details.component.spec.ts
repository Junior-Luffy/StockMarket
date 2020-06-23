import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CompareSectorDetailsComponent } from './compare-sector-details.component';

describe('CompareSectorDetailsComponent', () => {
  let component: CompareSectorDetailsComponent;
  let fixture: ComponentFixture<CompareSectorDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CompareSectorDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CompareSectorDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
