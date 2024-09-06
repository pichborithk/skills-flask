import javaScriptLogo from '../assets/images/JavaScript-logo.png';
import { FaUserCircle } from 'react-icons/fa';
import { useNavigate } from 'react-router-dom';

const CourseCard = () => {
  const nav = useNavigate();

  return (
    <div
      className='flex w-full items-center gap-4 rounded-lg p-4 shadow-2xl'
      onClick={() => {
        nav('/course/1');
      }}
    >
      <img src={javaScriptLogo} alt='javascript' className='w-40' />
      <div className='flex h-full grow flex-col justify-between pb-4'>
        <div className='flex flex-col gap-2'>
          <h3 className='text-2xl font-bold'>JavaScript Advance Topics</h3>
          <div className='flex gap-2 text-xs'>
            <p className='bg-secondary-500 text-secondary-50 rounded-full px-4 py-2'>
              Frontend
            </p>
            <p className='bg-secondary-500 text-secondary-50 rounded-full px-4 py-2'>
              Backend
            </p>
            <p className='bg-secondary-500 text-secondary-50 rounded-full px-4 py-2'>
              DevOps
            </p>
          </div>
        </div>
        <div className='flex justify-between'>
          <div className='flex items-center gap-2'>
            <FaUserCircle size={40} color='orange' />
            <div>
              <p>Uzumaki Naruto</p>
              <p className='text-xs text-slate-400'>
                Last updated: a minute ago
              </p>
            </div>
          </div>
          <div className='flex items-center gap-4 text-sm'>
            <p>651,324 Views</p>
            <p>36,6545 Likes</p>
            <p>56 comments</p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default CourseCard;
