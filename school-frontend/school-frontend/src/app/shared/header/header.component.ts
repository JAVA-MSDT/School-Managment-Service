import { Component, Input } from '@angular/core';

@Component({
  selector: 'school-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {

  @Input()
  containerStyle: any;
  @Input()
  isTitleDisplay: boolean = true;
  @Input()
  isDiscriptionDisplay: boolean = true;
}
