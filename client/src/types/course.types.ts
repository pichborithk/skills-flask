import { SectionResponse } from './section.types';
import { UserResponse } from './user.types';

export type CourseResponse = {
  id: number;
  title: string;
  price: number;
  instructor: UserResponse;
  sections: SectionResponse[];
};
