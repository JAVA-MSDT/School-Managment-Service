import { Component, Input, OnInit } from '@angular/core';
import { Image } from 'src/app/domains/shared/image';
import { NgbCarouselConfig } from '@ng-bootstrap/ng-bootstrap';


@Component({
  selector: 'b-best-carousel',
  templateUrl: './carousel.component.html',
  styleUrls: ['./carousel.component.sass'],
  providers: [NgbCarouselConfig]
})
export class CarouselComponent implements OnInit {

  @Input()
  carouselImage: Image[] = [];
  currentImage: Image = <Image>{};
  currentIndex: number = 0;
  constructor(config: NgbCarouselConfig) {
    // 
    config.interval = 4000;
    config.keyboard = true;
    config.pauseOnHover = true;
  }

  ngOnInit(): void {
  }

}
