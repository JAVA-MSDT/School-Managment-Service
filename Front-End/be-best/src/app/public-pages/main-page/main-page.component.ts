import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { API_NAME } from 'src/app/app-config/app.conestant';
import { ROUTER_PATH } from 'src/app/app-config/router-path-const';
import { Training } from 'src/app/domains/training/training';
import { ApiService } from 'src/app/service/api/api.service';

@Component({
  selector: 'dc-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.sass'],
})
export class MainPageComponent implements OnInit {
  trainings: Training[] = [];
  readonly trainingsApi = API_NAME.PUBLIC + ROUTER_PATH.contextPath + API_NAME.TRAININGS;

  constructor(
    private apiService: ApiService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.apiService.get<Training[]>(this.trainingsApi).subscribe((training) => {
      this.trainings = training.slice(0, 3);
      console.log(this.trainings);
    });
  }

  goToTrainingPage(trainingId: any) {
    this.router.navigate([trainingId], { relativeTo: this.route });
  }
}
