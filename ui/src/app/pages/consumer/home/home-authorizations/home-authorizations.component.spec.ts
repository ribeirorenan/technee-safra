import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeAuthorizationsComponent } from './home-authorizations.component';

describe('HomeAuthorizationsComponent', () => {
  let component: HomeAuthorizationsComponent;
  let fixture: ComponentFixture<HomeAuthorizationsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeAuthorizationsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeAuthorizationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
