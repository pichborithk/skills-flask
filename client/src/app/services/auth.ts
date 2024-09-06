// import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react';
// import { AuthResponse, UserRequest } from '../../types/user.types';

// export const authSlice = createApi({
//   reducerPath: 'auth',
//   baseQuery: fetchBaseQuery({ baseUrl: `${import.meta.env.VITE_API_URL}` }),
//   endpoints: builder => ({
//     register: builder.mutation<AuthResponse, UserRequest>({
//       query: user => ({
//         url: 'register',
//         method: 'POST',
//         body: user,
//       }),
//     }),
//   }),
// });

// export const { useRegisterMutation } = authSlice;
