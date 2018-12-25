import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HeaderMenuComponentComponent } from './header-menu-component.component';

describe('HeaderMenuComponentComponent', () => {
  let component: HeaderMenuComponentComponent;
  let fixture: ComponentFixture<HeaderMenuComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HeaderMenuComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HeaderMenuComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
