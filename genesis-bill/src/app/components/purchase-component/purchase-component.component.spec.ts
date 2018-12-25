import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PurchaseComponentComponent } from './purchase-component.component';

describe('PurchaseComponentComponent', () => {
  let component: PurchaseComponentComponent;
  let fixture: ComponentFixture<PurchaseComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PurchaseComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PurchaseComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
