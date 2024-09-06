import { section } from './section.types';
import { User } from './user.types';

export type Course = {
  id: number;
  title: string;
  price: number;
  instructor: User;
  sections: section[];
};
