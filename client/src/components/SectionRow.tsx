import { Link } from 'react-router-dom';
import { createPortal } from 'react-dom';
import { useState } from 'react';

import { SectionResponse } from '../types/section.types';
import { UpdateSectionModal } from '../components';

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

export default SectionRow;
