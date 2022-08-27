import { Description } from "../shared/map-string";

export interface Training {
    id?: string;
    title: string;
    subjectId: string;
    teacherId: string;
    startingDate: string;
    endDate: string;
    trainingStatus: string;
    description: Description;
  }