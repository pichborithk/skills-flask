import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react';
import { UserResponse } from '../../types/user.types';

export const userSlice = createApi({
  reducerPath: 'users',
  baseQuery: fetchBaseQuery({ baseUrl: `${import.meta.env.VITE_API_URL}` }),
  endpoints: builder => ({
    getUser: builder.query<UserResponse, string>({
      query: token => ({
        url: 'users',
        method: 'GET',
        headers: {
          Authorization: `Bearer ${token}`,
        },
      }),
    }),
  }),
});

export const { useGetUserQuery } = userSlice;
