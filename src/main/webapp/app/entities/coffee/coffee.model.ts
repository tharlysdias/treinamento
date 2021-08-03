import { IPerson } from 'app/entities/person/person.model';

export interface ICoffee {
  id?: string;
  name?: string;
  capacity?: number;
  people?: IPerson[] | null;
}

export class Coffee implements ICoffee {
  constructor(public id?: string, public name?: string, public capacity?: number, public people?: IPerson[] | null) {}
}

export function getCoffeeIdentifier(coffee: ICoffee): string | undefined {
  return coffee.id;
}
