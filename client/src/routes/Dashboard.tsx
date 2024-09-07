import { PiHandWavingFill } from 'react-icons/pi';

import { useAppSelector } from '../app/hooks';
import { useGetUserQuery } from '../app/services';
import Loading from '../components/Loading';
import { Link, Outlet, useNavigate } from 'react-router-dom';

const Dashboard = () => {
  const { token } = useAppSelector(state => state.auth);
  const { data: user, isLoading } = useGetUserQuery(token);
  const navigate = useNavigate();

  if (isLoading) return <Loading />;

  if (!token) return navigate('/');

  return (
    <div className='bg-slate-100'>
      <div className='section-min-height mx-auto flex max-w-7xl flex-col gap-8 py-40'>
        <div className='flex items-center gap-2 px-8 text-3xl font-bold'>
          <p>Hello {user?.username}</p>
          <PiHandWavingFill color='hotpink' />
        </div>
        <ul className='grid grid-cols-3 justify-around rounded-md bg-slate-50 py-4 text-center text-2xl font-semibold shadow-sm'>
          <li className='border-r-2'>
            <Link to='/dashboard'>Profile</Link>
          </li>
          <li className='border-r-2'>
            <Link to='/dashboard/courses'>Courses</Link>
          </li>
          <li>Mail</li>
        </ul>
        <Outlet />
      </div>
    </div>
  );
};

export default Dashboard;
