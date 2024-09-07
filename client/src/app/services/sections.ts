import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react';
import { SectionResponse } from '../../types/section.types';

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
  }),
});

export const { useGetSectionByIdQuery } = sectionSlice;
