import { Component, OnInit } from '@angular/core';
import { DomSanitizer, SafeUrl } from '@angular/platform-browser';
import { Image } from 'src/app/domains/shared/image';
import {
  API_PATH_NAME,
  FILE_METADATE,
} from 'src/app/app-config/app.conestant';
import { ApiService } from 'src/app/service/api/api.service';
import { IMAGE_STATIC_ID } from 'src/app/app-config/image-static-id';

@Component({
  selector: 'b-best-scroll-top',
  templateUrl: './scroll-top.component.html',
  styleUrls: ['./scroll-top.component.sass'],
})
export class ScrollTopComponent implements OnInit {
  scrollTopImage: SafeUrl = <SafeUrl>{};
  image: Image = <Image>{};

  constructor(
    private apiService: ApiService,
    private sanitizer: DomSanitizer
  ) {}

  ngOnInit(): void {
    this.getScrollTopImage();
  }

  toTop(): void {
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
  }

  getScrollTopImage(): void {
    this.apiService
      .get<Image>(
        API_PATH_NAME.IMAGES_PUBLIC_PATH + IMAGE_STATIC_ID.SCROLL_TOP_ICON
      )
      .subscribe((image) => {
        this.image = image;
      });
  }
}
