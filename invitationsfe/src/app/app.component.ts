import { CdkDragDrop, moveItemInArray } from '@angular/cdk/drag-drop';
import { Component, OnInit } from '@angular/core';
import { PersonResponse } from './models/PersonResponse';
import { PersonService } from './service/person.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [PersonService]
})
export class AppComponent implements OnInit{
 
  public listPerson: PersonResponse[] = []; 
  public guests: PersonResponse[] = [];
  
  constructor(private service: PersonService){}

  ngOnInit(): void {
      this.service.getPersons().subscribe(
        res => {
          this.listPerson = res;
          console.log(this.listPerson)
        },
        err => {
          console.log(err);
        }
      )
  }

  /* movies = [
    'Episode I - The Phantom Menace',
    'Episode II - Attack of the Clones',
    'Episode III - Revenge of the Sith',
    'Episode IV - A New Hope',
    'Episode V - The Empire Strikes Back',
    'Episode VI - Return of the Jedi',
    'Episode VII - The Force Awakens',
    'Episode VIII - The Last Jedi',
    'Episode IX – The Rise of Skywalker',
  ]; 
  */

  drop(event: CdkDragDrop<string[]>) {
    moveItemInArray(this.listPerson, event.previousIndex, event.currentIndex);
  } 

}
