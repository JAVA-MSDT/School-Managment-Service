import { Component } from '@angular/core';

@Component({
  selector: 'school-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.scss']
})
export class HomepageComponent {

  containerStyle: any = {
    backgroundColor: 'aqua',
    backgroundImage:'url(assets/image/kid_studying.jpg)',
    backgroundRepeat:'no-repeat',
    backgroundSize: 'cover',
    height:'500px',
  }
}
