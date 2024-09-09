import { Link, useParams } from 'react-router-dom';
import { FaArrowLeft } from 'react-icons/fa6';
import { useState } from 'react';
import { createPortal } from 'react-dom';

import { useGetCourseByIdQuery } from '../app/services';
import Loading from '../components/Loading';
import { CreateSectionModal, SectionRow } from '../components';

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
        <div className='flex items-center gap-4 px-4 text-4xl font-bold text-primary'>
          <Link to='/dashboard/courses'>
            <FaArrowLeft />
          </Link>
          <h1>{course?.title}</h1>
        </div>

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
