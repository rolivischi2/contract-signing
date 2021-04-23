import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InlinePdfViewerComponent } from './inline-pdf-viewer.component';

describe('InlinePdfViewerComponent', () => {
  let component: InlinePdfViewerComponent;
  let fixture: ComponentFixture<InlinePdfViewerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InlinePdfViewerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InlinePdfViewerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
