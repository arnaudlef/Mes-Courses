import { Component, OnInit, signal } from '@angular/core';
import { NavigationEnd, Router, RouterOutlet } from '@angular/router';
import { Navbar } from "./core/layout/navbar/navbar";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Navbar],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App implements OnInit {
  protected readonly title = signal('mes-courses-app');

  href: string = "";

  constructor(
    private router : Router
  ) {}

  ngOnInit(): void {
    this.router.events
      .subscribe(event => {
        if (event instanceof NavigationEnd ) {
          this.href = event.url;
        }
      })
  }
}
