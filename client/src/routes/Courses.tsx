import { FaUserCircle } from 'react-icons/fa';

import { useGetCoursesQuery } from '../app/services/courses';
import { FilterTag, Podcasts } from '../components';
import CourseCard from '../components/CourseCard';

const Courses = () => {
  const { data } = useGetCoursesQuery();

  return (
    <div className='section-min-height mx-auto grid max-w-7xl grid-cols-5 justify-between gap-8 py-40'>
      <FilterTag />
      <div className='col-span-3 flex flex-col items-center justify-start gap-8'>
        <div className='flex w-full items-center justify-between gap-4 rounded-lg p-4 shadow-2xl'>
          <FaUserCircle size={40} color='orange' />
          <input
            placeholder='Search...'
            className='w-full rounded-lg bg-slate-100 px-4 py-2 focus:outline-none'
          />
        </div>
        {data?.map(course => <CourseCard course={course} key={course.id} />)}
      </div>

      <Podcasts />
    </div>
  );
};

export default Courses;
