import { Component, OnInit } from '@angular/core';
import { API_NAME } from 'src/app/app-config/app.conestant';
import { Training } from 'src/app/domains/training/training';
import { ApiService } from 'src/app/service/api/api.service';

@Component({
  selector: 'b-best-training-zone',
  templateUrl: './training-zone.component.html',
  styleUrls: ['./training-zone.component.sass']
})
export class TrainingZoneComponent implements OnInit {

  trainings: Training[] = [];
  readonly trainingsApi = API_NAME.TRAININGS;
  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
    this.apiService.get<Training[]>(this.trainingsApi).subscribe((training) => {
      this.trainings = training;
      console.log("TrainingZoneComponent:: " )
      console.log(this.trainings)
    })
  }

}
