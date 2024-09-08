import { LectureResponse } from './lecture.types';

export type SectionResponse = {
  id: number;
  sequence: number;
  title: string;
  lectures: LectureResponse[];
};

export type SectionRequest = {
  token: string;
  id: number;
  sequence: number;
  title: string;
  courseId: number;
};
