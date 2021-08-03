import { IEvent } from 'app/entities/event/event.model';
import { ICoffee } from 'app/entities/coffee/coffee.model';

export interface IPerson {
  id?: string;
  firstName?: string;
  lastName?: string | null;
  events?: IEvent[] | null;
  coffees?: ICoffee[] | null;
}

export class Person implements IPerson {
  constructor(
    public id?: string,
    public firstName?: string,
    public lastName?: string | null,
    public events?: IEvent[] | null,
    public coffees?: ICoffee[] | null
  ) {}
}

export function getPersonIdentifier(person: IPerson): string | undefined {
  return person.id;
}
