import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PurchaseCreateComponentComponent } from './purchase-create-component.component';

describe('PurchaseCreateComponentComponent', () => {
  let component: PurchaseCreateComponentComponent;
  let fixture: ComponentFixture<PurchaseCreateComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PurchaseCreateComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PurchaseCreateComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
