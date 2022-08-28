import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { API_NAME } from 'src/app/app-config/app.conestant';
import { ROUTER_PATH } from 'src/app/app-config/router-path-const';
import { Subject } from 'src/app/domains/training/subject';
import { Training } from 'src/app/domains/training/training';
import { User } from 'src/app/domains/user/user';
import { ApiService } from 'src/app/service/api/api.service';

@Component({
  selector: 'b-best-training',
  templateUrl: './training.component.html',
  styleUrls: ['./training.component.sass'],
})
export class TrainingComponent implements OnInit {
  readonly trainingsApi =
    API_NAME.PUBLIC +
    ROUTER_PATH.contextPath +
    API_NAME.TRAININGS +
    ROUTER_PATH.contextPath;

  readonly subjectsApi =
    API_NAME.PUBLIC +
    ROUTER_PATH.contextPath +
    API_NAME.SUBJECTS +
    ROUTER_PATH.contextPath;

  readonly usersApi =
    API_NAME.PUBLIC +
    ROUTER_PATH.contextPath +
    API_NAME.USERS +
    ROUTER_PATH.contextPath;

  training: Training = <Training>{};
  subject: Subject = <Subject>{};
  user: User = <User>{};
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
          .get<Training>(this.trainingsApi + this.trainingId)
          .subscribe((training) => {
            this.training = training;

            this.setSubject(training.subjectId);
            this.setUser(training.teacherId);
          });
      }
    });
  }

  setSubject(subjectId: string): void {
    this.apiService
      .get<Subject>(this.subjectsApi + subjectId)
      .subscribe((subject) => {
        this.subject = subject;
        console.log(this.subject);
      });
  }

  setUser(teacherId: string): void {
    this.apiService.get<User>(this.usersApi + teacherId).subscribe((user) => {
      this.user = user;
      console.log(this.user);
    });
  }
}
