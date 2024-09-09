import { Link, useParams } from 'react-router-dom';
import { useGetCourseByIdQuery } from '../app/services';
import Loading from '../components/Loading';
import { SectionResponse } from '../types/section.types';
import { useState } from 'react';
import { CreateSectionModal, UpdateSectionModal } from '../components';
import { createPortal } from 'react-dom';

type SectionRowProps = {
  section: SectionResponse;
  courseId: number;
  updateCourse: (close: () => void) => Promise<void>;
};

const SectionRow = ({ section, courseId, updateCourse }: SectionRowProps) => {
  const [isModalOpen, setIsModalOpen] = useState(false);

  return (
    <>
      <td className='pl-16 text-left'>{section.sequence}</td>
      <td className='text-left'>{section.title}</td>
      <td>
        <span className='rounded-md border-2 border-green-200 bg-green-100 px-4 py-2 text-sm text-green-600'>
          Active
        </span>
      </td>
      <td className='flex items-center justify-center gap-4'>
        <button
          onClick={() => setIsModalOpen(true)}
          className='rounded-md border-2 border-teal-200 bg-secondary px-4 py-2 text-sm text-slate-50'
        >
          Edit
        </button>
        <Link
          to={`/sections/${section.id}`}
          className='rounded-md border-2 border-pink-200 bg-primary px-4 py-2 text-sm text-slate-50'
        >
          View
        </Link>
      </td>
      {isModalOpen &&
        createPortal(
          <UpdateSectionModal
            close={() => setIsModalOpen(false)}
            courseId={courseId}
            updateCourse={updateCourse}
            section={section}
          />,
          document.body,
        )}
    </>
  );
};

const InstructorCourseBoard = () => {
  const { courseId } = useParams();

  const {
    data: course,
    isLoading,
    refetch,
  } = useGetCourseByIdQuery(Number(courseId!));

  const [isModalOpen, setIsModalOpen] = useState(false);

  async function updateCourse(close: () => void) {
    await refetch();
    close();
  }

  if (isLoading) return <Loading />;

  return (
    <>
      <div className='section-min-height mx-auto flex max-w-7xl flex-col gap-8 py-40'>
        <h1 className='px-8 text-4xl font-bold text-primary'>
          {course?.title}
        </h1>
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
                    <SectionRow
                      section={section}
                      courseId={course!.id}
                      updateCourse={updateCourse}
                    />
                  </tr>
                ))}
            </tbody>
          </table>
        </div>
        <button
          className='w-fit self-center rounded-md border-2 border-primary px-8 py-2 text-primary hover:bg-primary hover:text-slate-50'
          onClick={() => setIsModalOpen(true)}
        >
          Add New Section
        </button>
      </div>
      {isModalOpen &&
        createPortal(
          <CreateSectionModal
            close={() => setIsModalOpen(false)}
            courseId={course!.id}
            updateCourse={updateCourse}
          />,
          document.body,
        )}
    </>
  );
};

export default InstructorCourseBoard;
