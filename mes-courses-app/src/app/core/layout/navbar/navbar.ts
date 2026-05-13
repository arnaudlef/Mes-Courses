import { NgClass } from '@angular/common';
import { Component, Input } from '@angular/core';
import { RouterLink } from "@angular/router";

@Component({
  selector: 'app-navbar',
  imports: [RouterLink, NgClass],
  templateUrl: './navbar.html',
  styleUrl: './navbar.scss',
})
export class Navbar {
  @Input() currentPage: string = "";

  check() {
    console.log(this.currentPage)
  }
}
