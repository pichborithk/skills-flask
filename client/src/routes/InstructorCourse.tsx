import { Link, useParams } from 'react-router-dom';
import { useGetCourseByIdQuery } from '../app/services';
import Loading from '../components/Loading';
import { SectionResponse } from '../types/section.types';

const InstructorCourse = () => {
  const { courseId } = useParams();

  const { data: course, isLoading } = useGetCourseByIdQuery(Number(courseId!));

  if (isLoading) return <Loading />;

  return (
    <div className='section-min-height mx-auto flex max-w-7xl flex-col gap-8 py-40'>
      <h1 className='px-8 text-4xl font-bold text-primary'>{course?.title}</h1>
      <div className='w-full rounded-md bg-slate-50 shadow-sm'>
        <table className='table w-full table-auto'>
          <thead>
            <tr className='border-b-2 text-primary [&>th]:py-2'>
              <th className='pl-16 text-left'>No</th>
              <th className='text-left'>Title</th>
              <th>Status</th>
              <th></th>
            </tr>
          </thead>
          <tbody className='text-center'>
            {course?.sections
              ?.slice()
              .sort((a, b) => a.sequence - b.sequence)
              .map(section => (
                <tr
                  className='border-b-2 font-medium [&>td]:py-4'
                  key={section.id}
                >
                  <SectionRow section={section} />
                </tr>
              ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

type SectionRowProps = {
  section: SectionResponse;
};

const SectionRow = ({ section }: SectionRowProps) => {
  return (
    <>
      <td className='pl-16 text-left'>{section.sequence}</td>
      <td className='text-left'>{section.title}</td>
      <td>
        <span className='rounded-md border-2 border-green-200 bg-green-100 px-4 py-2 text-sm text-green-600'>
          Active
        </span>
      </td>
      <td>
        <Link
          to={`/sections/${section.id}`}
          className='rounded-md border-2 border-pink-200 bg-primary px-4 py-2 text-sm text-slate-50'
        >
          View
        </Link>
      </td>
    </>
  );
};

export default InstructorCourse;
