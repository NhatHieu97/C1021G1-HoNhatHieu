import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListVillaComponent } from './list-villa.component';

describe('ListVillaComponent', () => {
  let component: ListVillaComponent;
  let fixture: ComponentFixture<ListVillaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListVillaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListVillaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
