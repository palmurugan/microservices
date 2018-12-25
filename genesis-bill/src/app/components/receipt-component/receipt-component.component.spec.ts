import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReceiptComponentComponent } from './receipt-component.component';

describe('ReceiptComponentComponent', () => {
  let component: ReceiptComponentComponent;
  let fixture: ComponentFixture<ReceiptComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReceiptComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReceiptComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
