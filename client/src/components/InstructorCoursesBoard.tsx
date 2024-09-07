import { Link, useOutletContext } from 'react-router-dom';
import { useGetCoursesByInstructorIdQuery } from '../app/services';
import { DashboardContext } from '../types/Dashboard.types';
import Loading from './Loading';
import { CourseResponse } from '../types/course.types';

const InstructorCoursesBoard = () => {
  const { user } = useOutletContext<DashboardContext>();
  const { data: courses, isLoading } = useGetCoursesByInstructorIdQuery(
    user.id,
  );

  if (isLoading) return <Loading />;

  return (
    <div className='w-full rounded-md bg-slate-50 shadow-sm'>
      <table className='table w-full table-auto'>
        <thead>
          <tr className='border-b-2 text-primary [&>th]:py-2'>
            <th className='px-16 text-left'>Title</th>
            <th>Price</th>
            <th>Status</th>
            <th></th>
          </tr>
        </thead>
        <tbody className='text-center'>
          {courses?.map(course => (
            <tr className='border-b-2 font-medium [&>td]:py-4' key={course.id}>
              <CourseRow course={course} />
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

type CourseRowProps = {
  course: CourseResponse;
};

const CourseRow = ({ course }: CourseRowProps) => {
  return (
    <>
      <td className='px-16 text-left'>{course.title}</td>
      <td>{course.price} $</td>
      <td>
        <span className='rounded-md border-2 border-green-200 bg-green-100 px-4 py-2 text-sm text-green-600'>
          Active
        </span>
      </td>
      <td>
        <Link
          to='/'
          className='rounded-md border-2 border-pink-200 bg-primary px-4 py-2 text-sm text-slate-50'
        >
          View
        </Link>
      </td>
    </>
  );
};

export default InstructorCoursesBoard;
