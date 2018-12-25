import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DashBoardComponentComponent } from './dash-board-component.component';

describe('DashBoardComponentComponent', () => {
  let component: DashBoardComponentComponent;
  let fixture: ComponentFixture<DashBoardComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DashBoardComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DashBoardComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
