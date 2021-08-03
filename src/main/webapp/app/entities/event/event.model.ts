import { IPerson } from 'app/entities/person/person.model';

export interface IEvent {
  id?: string;
  name?: string;
  capacity?: number;
  people?: IPerson[] | null;
}

export class Event implements IEvent {
  constructor(public id?: string, public name?: string, public capacity?: number, public people?: IPerson[] | null) {}
}

export function getEventIdentifier(event: IEvent): string | undefined {
  return event.id;
}
