import { useParams } from 'react-router-dom';
import { useGetSectionByIdQuery } from '../app/services/sections';
import Loading from '../components/Loading';
import { LectureResponse } from '../types/lecture.types';

const Section = () => {
  const { sectionId } = useParams();
  const { data: section, isLoading } = useGetSectionByIdQuery(
    Number(sectionId!),
  );

  if (isLoading) return <Loading />;

  return (
    <div className='section-min-height mx-auto flex max-w-7xl flex-col gap-8 py-40'>
      <h1 className='px-8 text-4xl font-bold text-primary'>{section?.title}</h1>
      <div className='w-full rounded-md bg-slate-50 shadow-sm'>
        <table className='table w-full table-auto'>
          <thead>
            <tr className='border-b-2 text-primary [&>th]:py-2'>
              <th className='pl-16 text-left'>No</th>
              <th className='text-left'>Title</th>
              <th>Length</th>
              <th>Status</th>
              <th></th>
            </tr>
          </thead>
          <tbody className='text-center'>
            {section?.lectures
              ?.slice()
              .sort((a, b) => a.sequence - b.sequence)
              .map(lecture => (
                <tr
                  className='border-b-2 font-medium [&>td]:py-4'
                  key={lecture.id}
                >
                  <LectureRow lecture={lecture} />
                </tr>
              ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

type LectureRowProps = {
  lecture: LectureResponse;
};

const LectureRow = ({ lecture }: LectureRowProps) => {
  return (
    <>
      <td className='pl-16 text-left'>{lecture.sequence}</td>
      <td className='text-left'>{lecture.title}</td>
      <td>{lecture.length} mins</td>
      <td>
        <span className='rounded-md border-2 border-green-200 bg-green-100 px-4 py-2 text-sm text-green-600'>
          Active
        </span>
      </td>
      {/* <td>
        <Link
          to={`/sections/${section.id}`}
          className='rounded-md border-2 border-pink-200 bg-primary px-4 py-2 text-sm text-slate-50'
        >
          View
        </Link>
      </td> */}
    </>
  );
};

export default Section;
