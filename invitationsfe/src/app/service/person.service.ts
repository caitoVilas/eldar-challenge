import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable } from 'rxjs';
import { PersonRequest } from '../models/PersonRequest';
import { PersonResponse } from '../models/PersonResponse';

@Injectable({
  providedIn: 'root'
})
export class PersonService {

  private URL = "http://localhost:8080/api/v1/eldar/people"

  constructor(private http: HttpClient) { }

  

  public getPersons(): Observable<PersonResponse[]> {

    return this.http.get<PersonResponse[]>(this.URL);
  }

  public savePersons(person:PersonRequest): Observable<PersonResponse>{

    return this.http.post<PersonResponse>(this.URL, person);
  }

  public updatePerson(id: number, person:PersonRequest): Observable<PersonResponse>{

    return this.http.put<PersonResponse>(this.URL + '/' + id, person );
  }

  public deletePerson(id: number): Observable<any>{

    return this.http.delete<any>(this.URL + '/' + id);
  }
}
