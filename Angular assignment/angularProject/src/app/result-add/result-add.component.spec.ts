import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResultAddComponent } from './result-add.component';

describe('ResultAddComponent', () => {
  let component: ResultAddComponent;
  let fixture: ComponentFixture<ResultAddComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ResultAddComponent]
    });
    fixture = TestBed.createComponent(ResultAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
