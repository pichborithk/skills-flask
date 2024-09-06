import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react';
import { Course } from '../../types/course.types';

export const coursesApi = createApi({
  reducerPath: 'courses',
  baseQuery: fetchBaseQuery({ baseUrl: `${import.meta.env.VITE_API_URL}` }),
  endpoints: builder => ({
    getCourses: builder.query<Course[], void>({
      query: () => 'courses',
    }),
  }),
});

export const { useGetCoursesQuery } = coursesApi;
