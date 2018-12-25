import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerComponentComponent } from './customer-component.component';

describe('CustomerComponentComponent', () => {
  let component: CustomerComponentComponent;
  let fixture: ComponentFixture<CustomerComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
