jest.mock('@angular/router');

import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { of, Subject } from 'rxjs';

import { PersonService } from '../service/person.service';
import { IPerson, Person } from '../person.model';
import { IEvent } from 'app/entities/event/event.model';
import { EventService } from 'app/entities/event/service/event.service';
import { ICoffee } from 'app/entities/coffee/coffee.model';
import { CoffeeService } from 'app/entities/coffee/service/coffee.service';

import { PersonUpdateComponent } from './person-update.component';

describe('Component Tests', () => {
  describe('Person Management Update Component', () => {
    let comp: PersonUpdateComponent;
    let fixture: ComponentFixture<PersonUpdateComponent>;
    let activatedRoute: ActivatedRoute;
    let personService: PersonService;
    let eventService: EventService;
    let coffeeService: CoffeeService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
        declarations: [PersonUpdateComponent],
        providers: [FormBuilder, ActivatedRoute],
      })
        .overrideTemplate(PersonUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(PersonUpdateComponent);
      activatedRoute = TestBed.inject(ActivatedRoute);
      personService = TestBed.inject(PersonService);
      eventService = TestBed.inject(EventService);
      coffeeService = TestBed.inject(CoffeeService);

      comp = fixture.componentInstance;
    });

    describe('ngOnInit', () => {
      it('Should call Event query and add missing value', () => {
        const person: IPerson = { id: '1361f429-3817-4123-8ee3-fdf8943310b2' };
        const events: IEvent[] = [{ id: 'de4dafe0-5dde-4ab9-b16c-73fbf30fee08' }];
        person.events = events;

        const eventCollection: IEvent[] = [{ id: '6089d33b-4ad3-42f3-beab-d6e620903151' }];
        jest.spyOn(eventService, 'query').mockReturnValue(of(new HttpResponse({ body: eventCollection })));
        const additionalEvents = [...events];
        const expectedCollection: IEvent[] = [...additionalEvents, ...eventCollection];
        jest.spyOn(eventService, 'addEventToCollectionIfMissing').mockReturnValue(expectedCollection);

        activatedRoute.data = of({ person });
        comp.ngOnInit();

        expect(eventService.query).toHaveBeenCalled();
        expect(eventService.addEventToCollectionIfMissing).toHaveBeenCalledWith(eventCollection, ...additionalEvents);
        expect(comp.eventsSharedCollection).toEqual(expectedCollection);
      });

      it('Should call Coffee query and add missing value', () => {
        const person: IPerson = { id: '1361f429-3817-4123-8ee3-fdf8943310b2' };
        const coffees: ICoffee[] = [{ id: '48f428a8-9376-4d4e-a5f1-7eac27352612' }];
        person.coffees = coffees;

        const coffeeCollection: ICoffee[] = [{ id: '41c149b1-dfd5-4a37-b79b-d12c6055d118' }];
        jest.spyOn(coffeeService, 'query').mockReturnValue(of(new HttpResponse({ body: coffeeCollection })));
        const additionalCoffees = [...coffees];
        const expectedCollection: ICoffee[] = [...additionalCoffees, ...coffeeCollection];
        jest.spyOn(coffeeService, 'addCoffeeToCollectionIfMissing').mockReturnValue(expectedCollection);

        activatedRoute.data = of({ person });
        comp.ngOnInit();

        expect(coffeeService.query).toHaveBeenCalled();
        expect(coffeeService.addCoffeeToCollectionIfMissing).toHaveBeenCalledWith(coffeeCollection, ...additionalCoffees);
        expect(comp.coffeesSharedCollection).toEqual(expectedCollection);
      });

      it('Should update editForm', () => {
        const person: IPerson = { id: '1361f429-3817-4123-8ee3-fdf8943310b2' };
        const events: IEvent = { id: '54c8e1ee-b0b2-422a-a682-ae66d8530222' };
        person.events = [events];
        const coffees: ICoffee = { id: 'f79abf9a-0efa-4df6-8605-3083ffa8636e' };
        person.coffees = [coffees];

        activatedRoute.data = of({ person });
        comp.ngOnInit();

        expect(comp.editForm.value).toEqual(expect.objectContaining(person));
        expect(comp.eventsSharedCollection).toContain(events);
        expect(comp.coffeesSharedCollection).toContain(coffees);
      });
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', () => {
        // GIVEN
        const saveSubject = new Subject<HttpResponse<Person>>();
        const person = { id: '9fec3727-3421-4967-b213-ba36557ca194' };
        jest.spyOn(personService, 'update').mockReturnValue(saveSubject);
        jest.spyOn(comp, 'previousState');
        activatedRoute.data = of({ person });
        comp.ngOnInit();

        // WHEN
        comp.save();
        expect(comp.isSaving).toEqual(true);
        saveSubject.next(new HttpResponse({ body: person }));
        saveSubject.complete();

        // THEN
        expect(comp.previousState).toHaveBeenCalled();
        expect(personService.update).toHaveBeenCalledWith(person);
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', () => {
        // GIVEN
        const saveSubject = new Subject<HttpResponse<Person>>();
        const person = new Person();
        jest.spyOn(personService, 'create').mockReturnValue(saveSubject);
        jest.spyOn(comp, 'previousState');
        activatedRoute.data = of({ person });
        comp.ngOnInit();

        // WHEN
        comp.save();
        expect(comp.isSaving).toEqual(true);
        saveSubject.next(new HttpResponse({ body: person }));
        saveSubject.complete();

        // THEN
        expect(personService.create).toHaveBeenCalledWith(person);
        expect(comp.isSaving).toEqual(false);
        expect(comp.previousState).toHaveBeenCalled();
      });

      it('Should set isSaving to false on error', () => {
        // GIVEN
        const saveSubject = new Subject<HttpResponse<Person>>();
        const person = { id: '9fec3727-3421-4967-b213-ba36557ca194' };
        jest.spyOn(personService, 'update').mockReturnValue(saveSubject);
        jest.spyOn(comp, 'previousState');
        activatedRoute.data = of({ person });
        comp.ngOnInit();

        // WHEN
        comp.save();
        expect(comp.isSaving).toEqual(true);
        saveSubject.error('This is an error!');

        // THEN
        expect(personService.update).toHaveBeenCalledWith(person);
        expect(comp.isSaving).toEqual(false);
        expect(comp.previousState).not.toHaveBeenCalled();
      });
    });

    describe('Tracking relationships identifiers', () => {
      describe('trackEventById', () => {
        it('Should return tracked Event primary key', () => {
          const entity = { id: '9fec3727-3421-4967-b213-ba36557ca194' };
          const trackResult = comp.trackEventById(0, entity);
          expect(trackResult).toEqual(entity.id);
        });
      });

      describe('trackCoffeeById', () => {
        it('Should return tracked Coffee primary key', () => {
          const entity = { id: '9fec3727-3421-4967-b213-ba36557ca194' };
          const trackResult = comp.trackCoffeeById(0, entity);
          expect(trackResult).toEqual(entity.id);
        });
      });
    });

    describe('Getting selected relationships', () => {
      describe('getSelectedEvent', () => {
        it('Should return option if no Event is selected', () => {
          const option = { id: '9fec3727-3421-4967-b213-ba36557ca194' };
          const result = comp.getSelectedEvent(option);
          expect(result === option).toEqual(true);
        });

        it('Should return selected Event for according option', () => {
          const option = { id: '9fec3727-3421-4967-b213-ba36557ca194' };
          const selected = { id: '9fec3727-3421-4967-b213-ba36557ca194' };
          const selected2 = { id: '1361f429-3817-4123-8ee3-fdf8943310b2' };
          const result = comp.getSelectedEvent(option, [selected2, selected]);
          expect(result === selected).toEqual(true);
          expect(result === selected2).toEqual(false);
          expect(result === option).toEqual(false);
        });

        it('Should return option if this Event is not selected', () => {
          const option = { id: '9fec3727-3421-4967-b213-ba36557ca194' };
          const selected = { id: '1361f429-3817-4123-8ee3-fdf8943310b2' };
          const result = comp.getSelectedEvent(option, [selected]);
          expect(result === option).toEqual(true);
          expect(result === selected).toEqual(false);
        });
      });

      describe('getSelectedCoffee', () => {
        it('Should return option if no Coffee is selected', () => {
          const option = { id: '9fec3727-3421-4967-b213-ba36557ca194' };
          const result = comp.getSelectedCoffee(option);
          expect(result === option).toEqual(true);
        });

        it('Should return selected Coffee for according option', () => {
          const option = { id: '9fec3727-3421-4967-b213-ba36557ca194' };
          const selected = { id: '9fec3727-3421-4967-b213-ba36557ca194' };
          const selected2 = { id: '1361f429-3817-4123-8ee3-fdf8943310b2' };
          const result = comp.getSelectedCoffee(option, [selected2, selected]);
          expect(result === selected).toEqual(true);
          expect(result === selected2).toEqual(false);
          expect(result === option).toEqual(false);
        });

        it('Should return option if this Coffee is not selected', () => {
          const option = { id: '9fec3727-3421-4967-b213-ba36557ca194' };
          const selected = { id: '1361f429-3817-4123-8ee3-fdf8943310b2' };
          const result = comp.getSelectedCoffee(option, [selected]);
          expect(result === option).toEqual(true);
          expect(result === selected).toEqual(false);
        });
      });
    });
  });
});
