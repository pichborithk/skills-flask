import { UserResponse } from './user.types';

export type DashboardContext = {
  token: string;
  user: UserResponse;
};
