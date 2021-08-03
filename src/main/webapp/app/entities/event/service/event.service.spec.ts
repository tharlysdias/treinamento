import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { IEvent, Event } from '../event.model';

import { EventService } from './event.service';

describe('Service Tests', () => {
  describe('Event Service', () => {
    let service: EventService;
    let httpMock: HttpTestingController;
    let elemDefault: IEvent;
    let expectedResult: IEvent | IEvent[] | boolean | null;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
      });
      expectedResult = null;
      service = TestBed.inject(EventService);
      httpMock = TestBed.inject(HttpTestingController);

      elemDefault = {
        id: 'AAAAAAA',
        name: 'AAAAAAA',
        capacity: 0,
      };
    });

    describe('Service methods', () => {
      it('should find an element', () => {
        const returnedFromService = Object.assign({}, elemDefault);

        service.find('9fec3727-3421-4967-b213-ba36557ca194').subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(elemDefault);
      });

      it('should create a Event', () => {
        const returnedFromService = Object.assign(
          {
            id: 'ID',
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.create(new Event()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a Event', () => {
        const returnedFromService = Object.assign(
          {
            id: 'BBBBBB',
            name: 'BBBBBB',
            capacity: 1,
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.update(expected).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should partial update a Event', () => {
        const patchObject = Object.assign(
          {
            name: 'BBBBBB',
          },
          new Event()
        );

        const returnedFromService = Object.assign(patchObject, elemDefault);

        const expected = Object.assign({}, returnedFromService);

        service.partialUpdate(patchObject).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'PATCH' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should return a list of Event', () => {
        const returnedFromService = Object.assign(
          {
            id: 'BBBBBB',
            name: 'BBBBBB',
            capacity: 1,
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.query().subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush([returnedFromService]);
        httpMock.verify();
        expect(expectedResult).toContainEqual(expected);
      });

      it('should delete a Event', () => {
        service.delete('9fec3727-3421-4967-b213-ba36557ca194').subscribe(resp => (expectedResult = resp.ok));

        const req = httpMock.expectOne({ method: 'DELETE' });
        req.flush({ status: 200 });
        expect(expectedResult);
      });

      describe('addEventToCollectionIfMissing', () => {
        it('should add a Event to an empty array', () => {
          const event: IEvent = { id: '9fec3727-3421-4967-b213-ba36557ca194' };
          expectedResult = service.addEventToCollectionIfMissing([], event);
          expect(expectedResult).toHaveLength(1);
          expect(expectedResult).toContain(event);
        });

        it('should not add a Event to an array that contains it', () => {
          const event: IEvent = { id: '9fec3727-3421-4967-b213-ba36557ca194' };
          const eventCollection: IEvent[] = [
            {
              ...event,
            },
            { id: '1361f429-3817-4123-8ee3-fdf8943310b2' },
          ];
          expectedResult = service.addEventToCollectionIfMissing(eventCollection, event);
          expect(expectedResult).toHaveLength(2);
        });

        it("should add a Event to an array that doesn't contain it", () => {
          const event: IEvent = { id: '9fec3727-3421-4967-b213-ba36557ca194' };
          const eventCollection: IEvent[] = [{ id: '1361f429-3817-4123-8ee3-fdf8943310b2' }];
          expectedResult = service.addEventToCollectionIfMissing(eventCollection, event);
          expect(expectedResult).toHaveLength(2);
          expect(expectedResult).toContain(event);
        });

        it('should add only unique Event to an array', () => {
          const eventArray: IEvent[] = [
            { id: '9fec3727-3421-4967-b213-ba36557ca194' },
            { id: '1361f429-3817-4123-8ee3-fdf8943310b2' },
            { id: '7b964918-74b8-4a28-9f0d-bf210480eda4' },
          ];
          const eventCollection: IEvent[] = [{ id: '9fec3727-3421-4967-b213-ba36557ca194' }];
          expectedResult = service.addEventToCollectionIfMissing(eventCollection, ...eventArray);
          expect(expectedResult).toHaveLength(3);
        });

        it('should accept varargs', () => {
          const event: IEvent = { id: '9fec3727-3421-4967-b213-ba36557ca194' };
          const event2: IEvent = { id: '1361f429-3817-4123-8ee3-fdf8943310b2' };
          expectedResult = service.addEventToCollectionIfMissing([], event, event2);
          expect(expectedResult).toHaveLength(2);
          expect(expectedResult).toContain(event);
          expect(expectedResult).toContain(event2);
        });

        it('should accept null and undefined values', () => {
          const event: IEvent = { id: '9fec3727-3421-4967-b213-ba36557ca194' };
          expectedResult = service.addEventToCollectionIfMissing([], null, event, undefined);
          expect(expectedResult).toHaveLength(1);
          expect(expectedResult).toContain(event);
        });

        it('should return initial array if no Event is added', () => {
          const eventCollection: IEvent[] = [{ id: '9fec3727-3421-4967-b213-ba36557ca194' }];
          expectedResult = service.addEventToCollectionIfMissing(eventCollection, undefined, null);
          expect(expectedResult).toEqual(eventCollection);
        });
      });
    });

    afterEach(() => {
      httpMock.verify();
    });
  });
});
