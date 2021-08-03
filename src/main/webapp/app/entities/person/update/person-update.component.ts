import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { finalize, map } from 'rxjs/operators';

import { IPerson, Person } from '../person.model';
import { PersonService } from '../service/person.service';
import { IEvent } from 'app/entities/event/event.model';
import { EventService } from 'app/entities/event/service/event.service';
import { ICoffee } from 'app/entities/coffee/coffee.model';
import { CoffeeService } from 'app/entities/coffee/service/coffee.service';

@Component({
  selector: 'jhi-person-update',
  templateUrl: './person-update.component.html',
})
export class PersonUpdateComponent implements OnInit {
  isSaving = false;

  eventsSharedCollection: IEvent[] = [];
  coffeesSharedCollection: ICoffee[] = [];

  editForm = this.fb.group({
    id: [],
    firstName: [null, [Validators.required, Validators.minLength(3), Validators.pattern('^[A-Z][a-z]+\\d$')]],
    lastName: [],
    events: [],
    coffees: [],
  });

  constructor(
    protected personService: PersonService,
    protected eventService: EventService,
    protected coffeeService: CoffeeService,
    protected activatedRoute: ActivatedRoute,
    protected fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ person }) => {
      this.updateForm(person);

      this.loadRelationshipsOptions();
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const person = this.createFromForm();
    if (person.id !== undefined) {
      this.subscribeToSaveResponse(this.personService.update(person));
    } else {
      this.subscribeToSaveResponse(this.personService.create(person));
    }
  }

  trackEventById(index: number, item: IEvent): string {
    return item.id!;
  }

  trackCoffeeById(index: number, item: ICoffee): string {
    return item.id!;
  }

  getSelectedEvent(option: IEvent, selectedVals?: IEvent[]): IEvent {
    if (selectedVals) {
      for (const selectedVal of selectedVals) {
        if (option.id === selectedVal.id) {
          return selectedVal;
        }
      }
    }
    return option;
  }

  getSelectedCoffee(option: ICoffee, selectedVals?: ICoffee[]): ICoffee {
    if (selectedVals) {
      for (const selectedVal of selectedVals) {
        if (option.id === selectedVal.id) {
          return selectedVal;
        }
      }
    }
    return option;
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IPerson>>): void {
    result.pipe(finalize(() => this.onSaveFinalize())).subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.previousState();
  }

  protected onSaveError(): void {
    // Api for inheritance.
  }

  protected onSaveFinalize(): void {
    this.isSaving = false;
  }

  protected updateForm(person: IPerson): void {
    this.editForm.patchValue({
      id: person.id,
      firstName: person.firstName,
      lastName: person.lastName,
      events: person.events,
      coffees: person.coffees,
    });

    this.eventsSharedCollection = this.eventService.addEventToCollectionIfMissing(this.eventsSharedCollection, ...(person.events ?? []));
    this.coffeesSharedCollection = this.coffeeService.addCoffeeToCollectionIfMissing(
      this.coffeesSharedCollection,
      ...(person.coffees ?? [])
    );
  }

  protected loadRelationshipsOptions(): void {
    this.eventService
      .query()
      .pipe(map((res: HttpResponse<IEvent[]>) => res.body ?? []))
      .pipe(
        map((events: IEvent[]) => this.eventService.addEventToCollectionIfMissing(events, ...(this.editForm.get('events')!.value ?? [])))
      )
      .subscribe((events: IEvent[]) => (this.eventsSharedCollection = events));

    this.coffeeService
      .query()
      .pipe(map((res: HttpResponse<ICoffee[]>) => res.body ?? []))
      .pipe(
        map((coffees: ICoffee[]) =>
          this.coffeeService.addCoffeeToCollectionIfMissing(coffees, ...(this.editForm.get('coffees')!.value ?? []))
        )
      )
      .subscribe((coffees: ICoffee[]) => (this.coffeesSharedCollection = coffees));
  }

  protected createFromForm(): IPerson {
    return {
      ...new Person(),
      id: this.editForm.get(['id'])!.value,
      firstName: this.editForm.get(['firstName'])!.value,
      lastName: this.editForm.get(['lastName'])!.value,
      events: this.editForm.get(['events'])!.value,
      coffees: this.editForm.get(['coffees'])!.value,
    };
  }
}
