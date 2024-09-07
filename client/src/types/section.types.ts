import { LectureResponse } from './lecture.types';

export type SectionResponse = {
  id: number;
  sequence: number;
  title: string;
  lectures: LectureResponse[];
};
