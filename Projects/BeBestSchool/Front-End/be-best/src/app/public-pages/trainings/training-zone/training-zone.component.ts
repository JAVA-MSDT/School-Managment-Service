import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { API_PATH_NAME } from 'src/app/app-config/app.conestant';
import { Training } from 'src/app/domains/training/training';
import { ApiService } from 'src/app/service/api/api.service';

@Component({
  selector: 'b-best-training-zone',
  templateUrl: './training-zone.component.html',
  styleUrls: ['./training-zone.component.sass'],
})
export class TrainingZoneComponent implements OnInit {
  trainings: Training[] = [];
  readonly trainingsApi = API_PATH_NAME.TRAININGS_PUBLIC_PATH;
  constructor(
    private apiService: ApiService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.apiService.get<Training[]>(this.trainingsApi).subscribe((training) => {
      this.trainings = training;
      console.log(this.trainings);
    });
  }

  goToTrainingPage(trainingId: any) {
    this.router.navigate([trainingId], { relativeTo: this.route });
  }
}
