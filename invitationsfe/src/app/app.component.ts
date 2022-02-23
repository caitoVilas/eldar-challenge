import { CdkDragDrop, moveItemInArray, transferArrayItem } from '@angular/cdk/drag-drop';
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

  drop(event: CdkDragDrop<PersonResponse[]>) {
    if (event.previousContainer === event.container) {
      moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
    } else {
      transferArrayItem(
        event.previousContainer.data,
        event.container.data,
        event.previousIndex,
        event.currentIndex,
      );
    }
  }   

}
