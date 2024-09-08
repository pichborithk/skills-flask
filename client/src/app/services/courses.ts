import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react';
import { CourseResponse } from '../../types/course.types';

export const courseSlice = createApi({
  reducerPath: 'courses',
  baseQuery: fetchBaseQuery({ baseUrl: `${import.meta.env.VITE_API_URL}` }),
  // tagTypes: ['Course'],
  endpoints: builder => ({
    getCourses: builder.query<CourseResponse[], void>({
      query: () => 'courses',
    }),

    getCourseById: builder.query<CourseResponse, number>({
      query: courseId => ({
        url: `courses/${courseId}`,
        method: 'GET',
      }),
      // providesTags: ['Course'],
    }),

    getCoursesByInstructorId: builder.query<CourseResponse[], number>({
      query: instructorId => ({
        url: `courses/instructor/${instructorId}`,
        method: 'GET',
      }),
    }),

    // createSection: builder.mutation<SectionResponse, Partial<SectionRequest>>({
    //   query: ({ token, ...section }) => ({
    //     url: `sections`,
    //     method: 'POST',
    //     headers: {
    //       Authorization: `Bearer ${token}`,
    //     },
    //     body: section,
    //   }),
    //   invalidatesTags: (result, error, arg) => [
    //     { type: 'Course', courseId: arg.courseId },
    //   ],
    // }),
  }),
});

export const {
  useGetCoursesQuery,
  useGetCourseByIdQuery,
  useGetCoursesByInstructorIdQuery,
} = courseSlice;
