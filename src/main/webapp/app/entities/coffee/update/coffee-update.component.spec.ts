jest.mock('@angular/router');

import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { of, Subject } from 'rxjs';

import { CoffeeService } from '../service/coffee.service';
import { ICoffee, Coffee } from '../coffee.model';

import { CoffeeUpdateComponent } from './coffee-update.component';

describe('Component Tests', () => {
  describe('Coffee Management Update Component', () => {
    let comp: CoffeeUpdateComponent;
    let fixture: ComponentFixture<CoffeeUpdateComponent>;
    let activatedRoute: ActivatedRoute;
    let coffeeService: CoffeeService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
        declarations: [CoffeeUpdateComponent],
        providers: [FormBuilder, ActivatedRoute],
      })
        .overrideTemplate(CoffeeUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(CoffeeUpdateComponent);
      activatedRoute = TestBed.inject(ActivatedRoute);
      coffeeService = TestBed.inject(CoffeeService);

      comp = fixture.componentInstance;
    });

    describe('ngOnInit', () => {
      it('Should update editForm', () => {
        const coffee: ICoffee = { id: '1361f429-3817-4123-8ee3-fdf8943310b2' };

        activatedRoute.data = of({ coffee });
        comp.ngOnInit();

        expect(comp.editForm.value).toEqual(expect.objectContaining(coffee));
      });
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', () => {
        // GIVEN
        const saveSubject = new Subject<HttpResponse<Coffee>>();
        const coffee = { id: '9fec3727-3421-4967-b213-ba36557ca194' };
        jest.spyOn(coffeeService, 'update').mockReturnValue(saveSubject);
        jest.spyOn(comp, 'previousState');
        activatedRoute.data = of({ coffee });
        comp.ngOnInit();

        // WHEN
        comp.save();
        expect(comp.isSaving).toEqual(true);
        saveSubject.next(new HttpResponse({ body: coffee }));
        saveSubject.complete();

        // THEN
        expect(comp.previousState).toHaveBeenCalled();
        expect(coffeeService.update).toHaveBeenCalledWith(coffee);
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', () => {
        // GIVEN
        const saveSubject = new Subject<HttpResponse<Coffee>>();
        const coffee = new Coffee();
        jest.spyOn(coffeeService, 'create').mockReturnValue(saveSubject);
        jest.spyOn(comp, 'previousState');
        activatedRoute.data = of({ coffee });
        comp.ngOnInit();

        // WHEN
        comp.save();
        expect(comp.isSaving).toEqual(true);
        saveSubject.next(new HttpResponse({ body: coffee }));
        saveSubject.complete();

        // THEN
        expect(coffeeService.create).toHaveBeenCalledWith(coffee);
        expect(comp.isSaving).toEqual(false);
        expect(comp.previousState).toHaveBeenCalled();
      });

      it('Should set isSaving to false on error', () => {
        // GIVEN
        const saveSubject = new Subject<HttpResponse<Coffee>>();
        const coffee = { id: '9fec3727-3421-4967-b213-ba36557ca194' };
        jest.spyOn(coffeeService, 'update').mockReturnValue(saveSubject);
        jest.spyOn(comp, 'previousState');
        activatedRoute.data = of({ coffee });
        comp.ngOnInit();

        // WHEN
        comp.save();
        expect(comp.isSaving).toEqual(true);
        saveSubject.error('This is an error!');

        // THEN
        expect(coffeeService.update).toHaveBeenCalledWith(coffee);
        expect(comp.isSaving).toEqual(false);
        expect(comp.previousState).not.toHaveBeenCalled();
      });
    });
  });
});
