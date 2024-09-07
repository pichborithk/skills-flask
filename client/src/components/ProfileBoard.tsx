import { FaUserCircle } from 'react-icons/fa';
import { useOutletContext } from 'react-router-dom';
import { DashboardContext } from '../types/Dashboard.types';

const ProfileBoard = () => {
  const { user } = useOutletContext<DashboardContext>();

  return (
    <div className='flex min-h-full grow flex-col items-center gap-8 rounded-md bg-slate-50 py-16 shadow-sm'>
      <FaUserCircle size={120} color='hotpink' />
      <div className='flex flex-col items-center gap-4 text-xl font-medium'>
        <div className='grid w-full grid-cols-2 gap-4'>
          <p className='text-right'>Username:</p>
          <p className='border-b-2'>{user.username}</p>
        </div>
        <div className='grid w-full grow grid-cols-2 gap-4'>
          <p className='text-right'>Role:</p>
          <p className='border-b-2'>{user.role}</p>
        </div>
      </div>
    </div>
  );
};

export default ProfileBoard;
