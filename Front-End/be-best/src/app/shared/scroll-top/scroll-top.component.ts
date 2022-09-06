import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'b-best-scroll-top',
  templateUrl: './scroll-top.component.html',
  styleUrls: ['./scroll-top.component.sass']
})
export class ScrollTopComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  toTop(): void {
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
  }
  
}
