import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { API_NAME } from 'src/app/app-config/app.conestant';
import { ROUTER_PATH } from 'src/app/app-config/router-path-const';
import { Training } from 'src/app/domains/training/training';
import { ApiService } from 'src/app/service/api/api.service';

@Component({
  selector: 'b-best-training',
  templateUrl: './training.component.html',
  styleUrls: ['./training.component.sass'],
})
export class TrainingComponent implements OnInit {
  readonly trainingsApi = API_NAME.TRAININGS;
  readonly subjectsApi = API_NAME.SUBJECTS;
  readonly usersApi = API_NAME.USERS;

  training: Training = <Training>{};
  trainingId!: string | null;

  constructor(
    private apiService: ApiService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe((param: ParamMap) => {
      this.trainingId = param.get('id');
      if (this.trainingId != null) {
        this.apiService
          .get<Training>(
            this.trainingsApi + ROUTER_PATH.contextPath + this.trainingId
          )
          .subscribe((training) => {
            this.training = training;
          });
        /* 
        this.apiService
          .get<Training>(
            this.trainingsApi + ROUTER_PATH.contextPath + this.trainingId
          )
          .subscribe((training) => {
            this.training = training;
          });

        this.apiService
          .get<Training>(
            this.trainingsApi + ROUTER_PATH.contextPath + this.trainingId
          )
          .subscribe((training) => {
            this.training = training;
          }); 
          */
      }
    });
  }
}
