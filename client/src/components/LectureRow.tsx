import { LectureResponse } from '../types/lecture.types';

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

export default LectureRow;
