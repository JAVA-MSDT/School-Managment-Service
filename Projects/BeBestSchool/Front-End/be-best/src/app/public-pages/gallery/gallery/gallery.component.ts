import { Component, OnInit } from '@angular/core';
import { API_PATH_NAME } from 'src/app/app-config/app.conestant';
import { Image } from 'src/app/domains/shared/image';
import { ApiService } from 'src/app/service/api/api.service';

@Component({
  selector: 'b-best-gallery',
  templateUrl: './gallery.component.html',
  styleUrls: ['./gallery.component.sass'],
})
export class GalleryComponent implements OnInit {
  readonly imagesApi = API_PATH_NAME.IMAGES_PUBLIC_PATH;
  images: Image[] = [];
  carouselOneImages: Image[] = [];
  constructor(private apiService: ApiService) {}

  ngOnInit(): void {
    this.getImages();
    this.getCarouselOneImages();
  }

  getImages(): void {
    this.apiService.get<Image[]>(this.imagesApi + 'place-purpose?placeOfUsed=1&purposeOfUses=UTIL').subscribe((images) => {
      this.images = images;
    });
  }

  getCarouselOneImages(): void {
    this.apiService
      .get<Image[]>(
        this.imagesApi + 'place-purpose?placeOfUsed=1&purposeOfUses=CAROUSEL'
      )
      .subscribe((images) => {
        this.carouselOneImages = images;
      });
  }
}
