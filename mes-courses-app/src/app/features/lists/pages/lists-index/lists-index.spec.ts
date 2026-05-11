import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListsIndex } from './lists-index';

describe('ListsIndex', () => {
  let component: ListsIndex;
  let fixture: ComponentFixture<ListsIndex>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListsIndex],
    }).compileComponents();

    fixture = TestBed.createComponent(ListsIndex);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
