import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react';
import { SectionRequest, SectionResponse } from '../../types/section.types';

export const sectionSlice = createApi({
  reducerPath: 'sections',
  baseQuery: fetchBaseQuery({ baseUrl: `${import.meta.env.VITE_API_URL}` }),
  endpoints: builder => ({
    getSectionById: builder.query<SectionResponse, number>({
      query: sectionId => ({
        url: `sections/${sectionId}`,
        method: 'GET',
      }),
    }),

    createSection: builder.mutation<SectionResponse, Partial<SectionRequest>>({
      query: ({ token, ...section }) => ({
        url: `sections`,
        method: 'POST',
        headers: {
          Authorization: `Bearer ${token}`,
        },
        body: section,
      }),
    }),
  }),
});

export const { useGetSectionByIdQuery, useCreateSectionMutation } =
  sectionSlice;
