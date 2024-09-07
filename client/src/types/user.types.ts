export type UserResponse = {
  id: number;
  username: string;
  role: string;
};

export type UserRequest = {
  username: string;
  password: string;
  role: string;
};

export type AuthResponse = {
  token: string;
};
