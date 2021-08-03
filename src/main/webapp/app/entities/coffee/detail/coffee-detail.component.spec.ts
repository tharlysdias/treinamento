import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { CoffeeDetailComponent } from './coffee-detail.component';

describe('Component Tests', () => {
  describe('Coffee Management Detail Component', () => {
    let comp: CoffeeDetailComponent;
    let fixture: ComponentFixture<CoffeeDetailComponent>;

    beforeEach(() => {
      TestBed.configureTestingModule({
        declarations: [CoffeeDetailComponent],
        providers: [
          {
            provide: ActivatedRoute,
            useValue: { data: of({ coffee: { id: '9fec3727-3421-4967-b213-ba36557ca194' } }) },
          },
        ],
      })
        .overrideTemplate(CoffeeDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(CoffeeDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load coffee on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.coffee).toEqual(expect.objectContaining({ id: '9fec3727-3421-4967-b213-ba36557ca194' }));
      });
    });
  });
});
