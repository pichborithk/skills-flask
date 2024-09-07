import { FaUserCircle } from 'react-icons/fa';
import { useGetUserQuery } from '../app/services';
import { useAppSelector } from '../app/hooks';

const ProfileBoard = () => {
  const { token } = useAppSelector(state => state.auth);
  const { data: user } = useGetUserQuery(token);

  return (
    <div className='flex min-h-full grow flex-col items-center gap-8 rounded-md bg-slate-50 py-8'>
      <FaUserCircle size={120} color='hotpink' />
      <div className='flex flex-col items-center gap-4 text-xl font-medium'>
        <div className='grid w-full grid-cols-2 gap-4'>
          <p className='text-right'>Username:</p>
          <p className='border-b-2'>{user?.username}</p>
        </div>
        <div className='grid w-full grow grid-cols-2 gap-4'>
          <p className='text-right'>Role:</p>
          <p className='border-b-2'>{user?.role}</p>
        </div>
      </div>
    </div>
  );
};

export default ProfileBoard;
