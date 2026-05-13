import { Component, OnInit } from '@angular/core';
import { ListService } from '../../services/list.service';

@Component({
  selector: 'app-lists-index',
  imports: [],
  templateUrl: './lists-index.html',
  styleUrl: './lists-index.scss',
})
export class ListsIndex implements OnInit {

  lists: any = [];

  constructor(
    private listService : ListService,
  ) {}

  ngOnInit(): void {
    this.getLists();
  }

  getLists() {
    this.listService.getLists()
      .subscribe({
          next: (lists) => {
            console.log(lists)
            this.lists = lists;
          },
          error: () => console.log('Impossible d\'afficher les recettes')
      });
  }

  
}
